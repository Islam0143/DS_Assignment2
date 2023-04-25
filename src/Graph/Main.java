package Graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.home"));
        System.out.println("enter the full path of the file:");
        Scanner scanner = new Scanner(System.in);
        // scan the whole line in case of spaces do exist in the file path.
        String filePath = scanner.nextLine();
        if(!filePath.contains(".txt"))
            filePath += ".txt";
        Graph graph = new Graph(filePath);
        System.out.println(graph.floydWarshall(null, null));
//        int src = 0;
//        int[] costs = new int[graph.size()];
//        int[] parents = new int[graph.size()];
//        System.out.println(graph.BellmanFord(src, costs, parents));
//        for(int i=0;i< graph.size();i++) System.out.print(costs[i]+ " ");
//        System.out.println();
//        for(int i=0;i< graph.size();i++) System.out.print(parents[i]+ " ");
    }


}