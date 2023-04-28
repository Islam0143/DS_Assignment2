package CLI;

import Graph.Graph;
import java.util.Scanner;
import java.util.Stack;

public class CLI {
    private Graph graph;
    private Scanner scanner;
    private int src = -1;
    private int[] costs;
    private int[] parents;
    private int[][] costs2D;
    private int[][] parents2D;
    private static final Integer INFINITY = Integer.MAX_VALUE / 3;

    public CLI() {
        do {
            System.out.println("Enter the full path of the file:");
            scanner = new Scanner(System.in);
            // scan the whole line in case of spaces do exist in the file path.
            String filePath = scanner.nextLine();
            if(!filePath.contains(".txt"))
                filePath += ".txt";
            graph = new Graph(filePath);
        } while (graph.errorReadingFile());
        int n = graph.size();
        costs = new int[n];
        parents = new int[n];
        costs2D = new int[n][n];
        parents2D = new int[n][n];
        mainMenu();
    }

    private void mainMenu() {
        while(true) {
            System.out.println("\t\t\t\t\t\tMain Menu");
            System.out.println("To find the shortest paths from source node to all other nodes enter 1: ");
            System.out.println("To find the shortest paths between all the pairs of nodes enter 2: ");
            System.out.println("To check if the graph contains a negative cycle enter 3: ");
            System.out.println("To exit enter 4: ");
            int option = scanner.nextInt();
            if(option == 1) {
                System.out.println("Enter the source node");
                src = scanner.nextInt();
                subMenu1(src);
            }
            else if(option == 2) subMenu1(-1);
            else if(option == 3) subMenu2();
            else if (option == 4) System.exit(0);
            else wrongOption();
        }
    }

    private void subMenu1(int src) {
        int option;
        while(true) {
            System.out.println("To choose Dijkstra's algorithm enter 1: ");
            System.out.println("To choose Bellman Ford's algorithm enter 2: ");
            System.out.println("To choose Floyd Warshall's algorithm enter 3: ");
            System.out.println("To return to main menu enter 4: ");
            option = scanner.nextInt();
            if(option == 4) return;
            if(option != 1 && option != 2 && option != 3) wrongOption();
            else break;
        }
        invoke(src, option);
    }

    private void subMenu2() {
        int option;
        while(true) {
            System.out.println("To choose Bellman Ford's algorithm enter 1: ");
            System.out.println("To choose Floyd Warshall's algorithm enter 2: ");
            System.out.println("To return to main menu enter 3: ");
            option = scanner.nextInt();
            if(option == 3) return;
            if(option != 1 && option != 2) wrongOption();
            else break;
        }
        checkNegativeCycles(option);
    }

    private void invoke(int src, int option) {
        if(src == -1) {                 //src == -1 indicates all pairs shortest path
            boolean floydChoosed = false;
            if(option == 1) {
                for(int i = 0; i < graph.size(); i++)
                    graph.Dijkstra(i,costs2D[i], parents2D[i]);
            }
            else if(option == 2) {
                for(int i = 0; i < graph.size(); i++)
                    graph.BellmanFord(i, costs2D[i], parents2D[i]);
            }
            else {
                graph.floydWarshall(costs2D, parents2D);
                floydChoosed = true;
            }
            allPairsOperations(floydChoosed);
        }
        else {                          //src != -1 indicates single source shortest path
            boolean floydChoosed = false;
            if(option == 1)
                graph.Dijkstra(src, costs, parents);
            else if(option == 2)
                graph.BellmanFord(src, costs, parents);
            else {
                graph.floydWarshall(costs2D, parents2D);
                costs = costs2D[src];
                floydChoosed = true;
            }
            singleSourceOperations(src, costs, parents, floydChoosed);
        }
    }

    public void checkNegativeCycles(int option) {
        boolean noNegativeCycles = true;
        if(option == 1)
            noNegativeCycles = graph.BellmanFord(0, costs, parents);
        else {
            noNegativeCycles = graph.floydWarshall(costs2D, parents2D);
        }
        if(noNegativeCycles) System.out.println("Graph has no negative cycles");
        else System.out.println("Graph contains negative cycle(s)");
    }

    private void singleSourceOperations(int src, int[] costs, int[] parents, boolean floydChoosed) {
        int option, dest;
        while(true) {
            System.out.println("To find the cost from source node " + src + " to specific node enter 1: ");
            System.out.println("To find the path from source node " + src + " to specific node enter 2: ");
            System.out.println("To return to main menu enter 3: ");
            option = scanner.nextInt();
            if(option == 1) {
                while(true) {
                    System.out.println("To go back enter -1: ");
                    System.out.println("Enter the desired node: ");
                    dest = scanner.nextInt();
                    if(dest == -1) break;
                    if (costs[dest] != INFINITY)
                        System.out.println("The cost is: " + costs[dest]);
                    else
                        System.out.println("No path, the cost is infinity");
                }
            }
            else if(option == 2) {
                while(true) {
                    System.out.println("To go back enter -1: ");
                    System.out.println("Enter the desired node: ");
                    dest = scanner.nextInt();
                    if(dest == -1) break;
                    if(floydChoosed)
                        pathTo2D(src, dest);
                    else
                        pathTo(src, dest, parents, costs);
                }
            }
            else if(option == 3) break;
            else wrongOption();
        }
    }

    private void allPairsOperations(boolean floydChoosed) {
        System.out.println("The cost of all shortest paths is: ");
        for(int i=0;i<costs2D.length;i++){
            for(int j=0;j<costs2D[i].length;j++){
                if(costs2D[i][j] != INFINITY)
                    System.out.println("The cost from node " + i + " to node " + j + " is: "
                        + costs2D[i][j]);
                else
                    System.out.println("The cost from node " + i + " to node " + j + " is: Infinity");

                if(!floydChoosed)
                    pathTo(i, j, parents2D[i], costs2D[i]);
                else
                    pathTo2D(i, j);
                System.out.println();
            }
        }
    }

    private void pathTo(int src, int dest, int[] parents, int[] costs) {
        if(src == dest && costs[src] < 0) {
            System.out.println("Infinite path");
            return;
        }
        if(parents[dest] == -1 && dest != src) {
            System.out.println("path does not exist");
            return;
        }
        Stack<Integer> pathStack = new Stack<>();
        pathStack.push(dest);
        int temp = dest;
        while(temp != src) {
            temp = parents[temp];
            pathStack.push(temp);
        }
        /*while(parents[dest] != -1 && src != dest) {
            pathStack.push(parents[dest]);
            dest = parents[dest];
        }*/
        System.out.print("The path is: ");
        while(!pathStack.isEmpty()) System.out.print(pathStack.pop() + " ");
        //while(!pathStack.isEmpty()) pathStack.pop();
        System.out.println();
    }

    private void pathTo2D(int src, int dest){
        /*if(dest == src && costs2D[src][dest] < 0) {
            System.out.println("Infinite path");
            return;
        }*/
        String Path = "";
        int tempDest = parents2D[src][dest];
        while(tempDest != dest && costs2D[tempDest][dest] != INFINITY){
            Path = Path.concat(Integer.toString(tempDest) + ", ");
            tempDest = parents2D[tempDest][dest];
        }
        System.out.print("The Path from " + src + " to " + dest + " is: ");
        if(costs2D[tempDest][dest] != INFINITY) {
            Path = Path.concat(Integer.toString(tempDest));
            Path = Integer.toString(src) + ", " + Path;
            System.out.println(Path);
        } else
            System.out.println("Does not exist.");
    }

    private void wrongOption() {
        System.out.println("No such option! please choose again");
    }

    public static void main(String[] args) {
        new CLI();
    }
}