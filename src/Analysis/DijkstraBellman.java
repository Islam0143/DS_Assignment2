package Analysis;

import Graph.Graph;

import java.util.Random;

public class DijkstraBellman {

    public static void main(String[] args) {
        long[][] BellmanTime = new long[39][3];
        long[][] DijkstraTime = new long[39][3];
        int [][] graphsSizeAndEdges = new int[39][2];

        for(int k = 0; k < 3; k++) {
            for(int i = 38; i < 39; i++) {
                Graph graph = new Graph("Input/graph" + i + ".txt");
                int E = graph.edgesNumber();
                int V = graph.size();
                graphsSizeAndEdges[i] = new int[]{V, E};
                int[] costs = new int[V];
                int[] parents = new int[V];
                int src = new Random().nextInt(V);
                long startTime = System.nanoTime();
                graph.BellmanFord(src, costs, parents);
                long endTime = System.nanoTime();
                BellmanTime[i][k] = endTime - startTime;
                startTime = System.nanoTime();
                graph.Dijkstra(src, costs, parents);
                endTime = System.nanoTime();
                DijkstraTime[i][k] = endTime - startTime;
            }
        }


        for(int i = 38; i < 39; i++) {
            long avgDijkstra = DijkstraTime[i][0] + DijkstraTime[i][1] + DijkstraTime[i][2];
            avgDijkstra /= 3;
            long avgBellman = BellmanTime[i][0] + BellmanTime[i][1] + BellmanTime[i][2];
            avgBellman /= 3;
            System.out.println(graphsSizeAndEdges[i][0]+"\t"+graphsSizeAndEdges[i][1]+"\t"+avgDijkstra+"\t"+avgBellman);
        }
    }
}
