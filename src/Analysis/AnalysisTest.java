package Analysis;

import Graph.Graph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnalysisTest {

    //-------------------------------------------------------Dijkstra - Bellman-----------------------------------------------------//

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Huge_Graph_5000_Vertices_200000_Edges() {
        Graph graph = new Graph("Input/test/graph20.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Huge_Graph_10000_Vertices_100000_Edges() {
        Graph graph = new Graph("Input/test/graph21.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Dense_Graph_200_Vertices_18000_Edges() {    //Dijkstra is faster than Bellman if dense graph
        Graph graph = new Graph("Input/test/denseGraph.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Dense_Graph_85_Vertices_3400_Edges() {    //Dijkstra is faster than Bellman if dense graph
        Graph graph = new Graph("Input/test/graph16.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Sparse_Graph_2000_Vertices_300_Edges() {    //Dijkstra is faster than Bellman if sparse graph
        Graph graph = new Graph("Input/test/sparseGraph.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Large_Graph_1500_Vertices_1700_Edges() {//if large graph Dijkstra is efficiently faster than Bellman
        Graph graph = new Graph("Input/test/graph14.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Bellman_For_Large_Graph_2000_Vertices_3000_Edges() {//if large graph Dijkstra is efficiently faster than Bellman
        Graph graph = new Graph("Input/test/graph15.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        long startTime = System.nanoTime();
        graph.Dijkstra(0, costs, parents);
        long endTime = System.nanoTime();
        long DijkstraTime = endTime - startTime;
        System.out.println(DijkstraTime);

        costs = new int[graph.size()];
        parents = new int[graph.size()];
        startTime = System.nanoTime();
        graph.BellmanFord(0, costs, parents);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);
        assertTrue(DijkstraTime < BellmanTime);
    }

    //------------------------------------------------Dijkstra - Floyd-----------------------------------------------//

    @Test
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Dense_Graph_200_Vertices_18000_Edges() {//if Dense Dijkstra is slower than floyd
        Graph graph = new Graph("Input/test/denseGraph.txt");
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
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Dense_Graph_85_Vertices_3400_Edges() {//if Dense Dijkstra is slower than floyd
        Graph graph = new Graph("Input/test/graph16.txt");
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
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Sparse_Graph_1500_Vertices_1700_Edges() {//if sparse Dijkstra is efficiently much faster
        Graph graph = new Graph("Input/test/graph14.txt");
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
        assertTrue(DijkstraTime < FloydTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Sparse_Graph_2000_Vertices_300_Edges() {//if sparse Dijkstra is efficiently much faster
        Graph graph = new Graph("Input/test/sparseGraph.txt");
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
        assertTrue(DijkstraTime < FloydTime);
    }

    @Test
    void Running_Time_Of_Dijkstra_Versus_Floyd_For_Graph_500_Vertices_1500_Edges() {
        Graph graph = new Graph("Input/test/graph17.txt");
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
        assertTrue(DijkstraTime < FloydTime);
    }


    //----------------------------------------------------Bellman - Floyd------------------------------------------------------//

    @Test
    void Running_Time_Of_Bellman_Versus_Floyd_For_Dense_Graph_200_Vertices_18000_Edges() {   //if Dense graph Bellman is slower than Floyd
        Graph graph = new Graph("Input/test/denseGraph.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        long startTime = System.nanoTime();
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall( costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(FloydTime < BellmanTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Floyd_For_Sparse_Graph_2000_Vertices_300_Edges() {      // if sparse graph Bellman is faster
        Graph graph = new Graph("Input/test/sparseGraph.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        long startTime = System.nanoTime();
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall( costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(BellmanTime < FloydTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Floyd_For_Sparse_Graph_500_Vertices_200_Edges() {      // if sparse graph Bellman is faster
        Graph graph = new Graph("Input/test/graph18.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        long startTime = System.nanoTime();
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall( costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(BellmanTime < FloydTime);
    }

    @Test
    void Running_Time_Of_Bellman_Versus_Floyd_For_Relatively_Large_Graph_750_Vertices_4000_Edges() {     //floyd is faster than bellman
        Graph graph = new Graph("Input/test/graph19.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        long startTime = System.nanoTime();
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        long endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall( costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(FloydTime < BellmanTime);
    }

    //-----------------------------------------------Dijkstra - Bellman - Floyd-------------------------------------------//

    @Test
    void The_3_Algorithms_For_Relatively_Large_Graph_750_Vertices_4000_Edges() {    //the fastest is Dijkstra then Floyd then Bellman
        Graph graph = new Graph("Input/test/graph19.txt");                        // but if the graph becomes more dense then floyd will become faster as it is independent of edges number
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
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall(costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(DijkstraTime < FloydTime);
        assertTrue(FloydTime < BellmanTime);        //Dijkstra < Floyd < Bellman
    }

    @Test
    void The_3_Algorithms_For_Dense_Graph_200_Vertices_18000_Edges() {    //the fastest is Floyd as it is independent of edges number
        Graph graph = new Graph("Input/test/denseGraph.txt");
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
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall(costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(FloydTime < DijkstraTime);
        assertTrue(DijkstraTime < BellmanTime);        //Floyd < Dijkstra < Bellman
    }

    @Test
    void The_3_Algorithms_For_Sparse_Graph_2000_Vertices_300_Edges() {    //the fastest is Dijkstra then Bellman then floyd
        Graph graph = new Graph("Input/test/sparseGraph.txt");
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
        for(int i=0;i< graph.size();i++)
            graph.BellmanFord(i, costs[i], parents[i]);
        endTime = System.nanoTime();
        long BellmanTime = endTime - startTime;
        System.out.println(BellmanTime);

        costs = new int[graph.size()][graph.size()];
        parents = new int[graph.size()][graph.size()];
        startTime = System.nanoTime();
        graph.floydWarshall(costs, parents);
        endTime = System.nanoTime();
        long FloydTime = endTime - startTime;
        System.out.println(FloydTime);
        assertTrue(DijkstraTime < BellmanTime);
        assertTrue(BellmanTime < FloydTime);        //Dijkstra < Bellman < Floyd
    }

}
