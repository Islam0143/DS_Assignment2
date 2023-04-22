package Graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {

    private ArrayList<Pair>[] adjacencyList;
    private int size;
    private static final Integer INFINITY = Integer.MAX_VALUE;

    public Graph(String filePath) {
        try {
            File myFile = new File(filePath);
            Scanner scanner = new Scanner(myFile);
            size = scanner.nextInt();      //# vertices
            int E = scanner.nextInt();      //# edges
            adjacencyList = new ArrayList[size];
            for(int i = 0; i < size; i++) adjacencyList[i] = new ArrayList<>();
            for(int i = 0; i < E; i++) {
                int[] edge = new int[3];
                edge[0] = scanner.nextInt();
                edge[1] = scanner.nextInt();
                edge[2] = scanner.nextInt();
                addEdge(edge[0], edge[1], edge[2]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            adjacencyList = null;
        }
    }

    private void addEdge(int from, int to, int weight) {
        adjacencyList[from].add(new Pair(to, weight));
    }

    public boolean BellmanFord(int src, int[] costs, int[] parents) {
        Arrays.fill(costs, INFINITY);
        costs[src] = 0;
        Arrays.fill(parents, -1);         //-1 indicates null
        for(int k = 0; k < size -1; k++) {      //n-1 iterations
            for(int i = 0; i < size; i++) {
                for(Pair edge: adjacencyList[i]) {      //for each edge
                    if(costs[i] != INFINITY && costs[i] + edge.weight < costs[edge.to]) {
                        costs[edge.to] = costs[i] + edge.weight;
                        parents[edge.to] = i;
                    }
                }
            }
        }
        //detect negative cycle
        for(int i = 0; i < size; i++)
            for(Pair edge: adjacencyList[i])       //for each edge
                if(costs[i] + edge.weight < costs[edge.to])
                    return false;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean errorReadingFile() {
        if(adjacencyList == null) {
            System.out.println("Cannot read file");
            return true;
        }
        return false;
    }
}