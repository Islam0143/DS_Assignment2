package Analysis;

import Graph.Graph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnalysisTest {

    @Test
    void Running_Time_Of_Bellman_Versus_Dijkstra_For_Dense_Graph_85_Vertices_2160_Edges() { //if not Dense Dijkstra is faster than bellman
        Graph graph = new Graph("Input/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);
        assertTrue(BellmanTime > DijkstraTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Dijkstra_For_Dense_Graph_100_Vertices_656_Edges() {//if Dense Dijkstra is faster than bellman
        Graph graph = new Graph("Input/graph7.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);
        assertTrue(BellmanTime > DijkstraTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Dijkstra_For_Sparse_Graph_66_Vertices_75_Edges() {//if sparse small Dijkstra is slower than bellman
        Graph graph = new Graph("Input/graph2.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);
        assertTrue(BellmanTime < DijkstraTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Dijkstra_For_Sparse_Graph_100_Vertices_120_Edges() {//if sparse small graphs Dijkstra is slower than bellman
        Graph graph = new Graph("Input/graph13.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);
        assertTrue(BellmanTime < DijkstraTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Dijkstra_For_Large_Graph_1500_Vertices_1700_Edges() {//if large graph Dijkstra is efficiently faster than Bellman
        Graph graph = new Graph("Input/graph14.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);
        assertTrue(BellmanTime > DijkstraTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Dijkstra_For_Large_Graph_2000_Vertices_3000_Edges() {//if large graph Dijkstra is efficiently faster than Bellman
        Graph graph = new Graph("Input/graph15.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);
        assertTrue(BellmanTime > DijkstraTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Dense_Graph_100_Vertices_656_Edges() {//if Dense Dijkstra is slower than floyd
        Graph graph = new Graph("Input/graph7.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        long startTime = System.nanoTime();
        for(int i=0;i< graph.size();i++)
            graph.Dijkstra(i, costs[i], parents[i]);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall( costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(FloydTime < DijkstraTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Dense_Graph_85_Vertices_2160_Edges() {//if Dense Dijkstra is slower than floyd
        Graph graph = new Graph("Input/graph5.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        long startTime = System.nanoTime();
        for(int i=0;i< graph.size();i++)
            graph.Dijkstra(i, costs[i], parents[i]);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall( costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(FloydTime < DijkstraTime);
    }


}
