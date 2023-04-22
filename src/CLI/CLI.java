package CLI;

import Graph.Graph;
import java.util.Scanner;
import java.util.Stack;

public class CLI {
    private Graph graph;
    private Scanner scanner;
    private int src;
    private int[] costs;
    private int[] parents;
    private int[][] costs2D;
    private int[][] parents2D;

    public CLI() {
        do {
            System.out.println("enter the full path of the file:");
            scanner = new Scanner(System.in);
            graph = new Graph(scanner.next() + ".txt");
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
                System.out.println("enter the source node");
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
        //TODO
    }

    private void invoke(int src, int option) {
        if(src == -1) {                 //src == -1 indicates all pairs shortest path
            if(option == 1) {
                for(int i = 0; i < graph.size(); i++) {
                    //TODO Dijkstra function call
                }
            }
            else if(option == 2) {
                for(int i = 0; i < graph.size(); i++)
                    graph.BellmanFord(i, costs2D[i], parents2D[i]);
            }
            else {
                //TODO Floyd warshall function call
            }
            allPairsOperations(costs2D, parents2D);
        }
        else {                          //src != -1 indicates single source shortest path
            if(option == 1) {
                //TODO Dijkstra function call
            }
            else if(option == 2)
                graph.BellmanFord(src, costs, parents);
            else {
                //TODO Floyd warshall function call
            }
            singleSourceOperations(src, costs, parents);
        }
    }

    public void checkNegativeCycles(int option) {
        boolean noNegativeCycles = true;
        if(option == 1)
            noNegativeCycles = graph.BellmanFord(0, costs, parents);
        else {
            //TODO Floyd warshall function call
        }
        if(noNegativeCycles) System.out.println("Graph has no negative cycles");
        else System.out.println("Graph contains a negative cycle");
    }

    private void singleSourceOperations(int src, int[] costs, int[] parents) {
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
                    System.out.println("The cost is: " + costs[dest]);
                }
            }
            else if(option == 2) {
                while(true) {
                    System.out.println("To go back enter -1: ");
                    System.out.println("Enter the desired node: ");
                    dest = scanner.nextInt();
                    if(dest == -1) break;
                    pathTo(dest, parents);
                }
            }
            else if(option == 3) break;
            else wrongOption();
        }
    }

    private void allPairsOperations(int[][] costs2D, int[][] parents2D) {
        //TODO
    }

    private void pathTo(int dest, int[] parents) {
        Stack<Integer> pathStack = new Stack<>();
        pathStack.push(dest);
        while(parents[dest] != -1) {
            pathStack.push(parents[dest]);
            dest = parents[dest];
        }
        System.out.print("The path is: ");
        while(!pathStack.isEmpty()) System.out.print(pathStack.pop() + " ");
        System.out.println();
    }

    private void wrongOption() {
        System.out.println("No such option! please choose again");
    }

    public static void main(String[] args) {
        new CLI();
    }
}