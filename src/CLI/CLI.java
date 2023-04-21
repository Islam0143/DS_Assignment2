package CLI;

import Graph.Graph;
import java.util.Scanner;

public class CLI {

    private Graph graph;
    private Scanner scanner;
    private int[] costs;
    private int[] parents;
    private int src;
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
            System.out.println("To go to main menu enter 4: ");
            option = scanner.nextInt();
            if(option != 1 && option != 2 && option != 3 && option != 4) wrongOption();
            else break;
        }
        invoke(src, option);
    }

    private void subMenu2() {
        System.out.println("To choose Bellman Ford's algorithm enter 1: ");
        System.out.println("To choose Floyd Warshall's algorithm enter 2: ");
        System.out.println("To go to main menu enter 3: ");
        //TODO
    }

    private void invoke(int src, int option) {
        if(src == -1) {             //indicates all pairs shortest path
            //TODO
        }
        else {                      //indicates single source shortest path
            if(option == 1) {
                //TODO Dijkstra function call
            }
            else if(option == 2)
                graph.BellmanFord(src, costs, parents);
            else {
                //TODO Floyd warshall function call
            }
        }
    }

    private void singleSourceOperations() {
        //TODO
    }

    private void allPairsOperations() {
        //TODO
    }

    private void wrongOption() {
        System.out.println("No such option!");
    }

    public static void main(String[] args) {
        new CLI();
    }
}