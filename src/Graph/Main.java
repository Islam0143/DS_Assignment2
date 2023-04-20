package Graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.home"));
        System.out.println("enter the full path of the file:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        Graph graph = new Graph(filePath + ".txt");
        int src = 0;
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.BellmanFord(src, costs, parents);
        for(int i=0;i< graph.size();i++) System.out.print(costs[i]+ " ");
        System.out.println();
        for(int i=0;i< graph.size();i++) System.out.print(parents[i]+ " ");
    }
}