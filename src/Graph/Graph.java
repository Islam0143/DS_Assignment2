package Graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    private ArrayList<Pair>[] adjacencyList;
    private int size;
    private static final Integer INFINITY = Integer.MAX_VALUE;

    public Graph(String filePath) {
        int n, m;
        try {
            File myFile = new File(filePath);
            Scanner scanner = new Scanner(myFile);
            n = scanner.nextInt();      //# vertices
            m = scanner.nextInt();      //# edges
            //System.out.println(n+" "+m);
            adjacencyList = new ArrayList[n];
            size = n;
            for(int i = 0; i < n; i++) adjacencyList[i] = new ArrayList<>();
            for(int i = 0; i < m; i++) {
                int[] edge = new int[3];
                edge[0] = scanner.nextInt();
                edge[1] = scanner.nextInt();
                edge[2] = scanner.nextInt();
                addEdge(edge[0], edge[1], edge[2]);
                //System.out.println(edge[0]+" "+edge[1]+" "+edge[2]);
            }
        } catch (Exception e) {
            System.out.println("file not found!");
        }
    }

    private void addEdge(int from, int to, int weight) {
        adjacencyList[from].add(new Pair(to, weight));
    }


    public boolean BellmanFord(int src, int[] costs, int[] parents) {
        for(int i = 0; i < costs.length; i++) costs[i] = INFINITY;
        costs[src] = 0;
        parents[src] = -1;  //-1 indicates null
        for(int k = 0; k < size -1; k++) {      //n-1 iterations
            for(int i = 0; i < size; i++) {
                for(Pair edge: adjacencyList[i]) {      //for each edge
                    if(costs[i] + edge.weight < costs[edge.to]) {
                        costs[edge.to] = costs[i] + edge.weight;
                        parents[edge.to] = i;
                    }
                }
            }
        }

        for(int i = 0; i < size; i++) {         //detect negative cycle
            for(Pair edge: adjacencyList[i]) {      //for each edge
                if(costs[i] + edge.weight < costs[edge.to]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int size() {
        return size;
    }
}
