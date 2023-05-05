package Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    private static final Integer INFINITY = 715827882;

    // 1 node without cycle
    @Test
    void Acyclic_1Node_D () {
        Graph graph = new Graph("Input/PerformanceTests/graph0.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertTrue(costs[0] == 0);
        assertTrue(parents[0] == -1);
    }
    @Test
    void Acyclic_1Node_B () {
        Graph graph = new Graph("Input/PerformanceTests/graph0.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);

        assertTrue( NoNegCycle== true);
        assertTrue(costs[0] == 0);
        assertTrue(parents[0] == -1);
    }
    @Test
    void Acyclic_1Node_F () {
        Graph graph = new Graph("Input/PerformanceTests/graph0.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);

        assertTrue( NoNegCycle== true);
        assertTrue(costs[0][0] == 0);
    }

    // 1 node with negative cycle
    @Test
    void cyclic_1NegNode_D () {
        Graph graph = new Graph("Input/PerformanceTests/graph1.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertTrue(costs[0] == 0);
        assertTrue(parents[0] == -1);
    }
    @Test
    void cyclic_1NegNode_B () {
        Graph graph = new Graph("Input/PerformanceTests/graph1.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);

        assertTrue( NoNegCycle== false);
        assertTrue(costs[0] == 0);
        assertTrue(parents[0] == -1);
    }
    @Test
    void cyclic_1NegNode_F () {
        Graph graph = new Graph("Input/PerformanceTests/graph1.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);

        assertTrue( NoNegCycle== false);                                    // neg cycle
    }

    // 2 weakly connected nodes
    @Test
    void simpleGraph2_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph2.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertEquals(5 , costs[1]);
        assertEquals(0, costs[0]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
    }
    @Test
    void simpleGraph2_AN_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph2.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(1, costs, parents);

        assertEquals(0 , costs[1]);
        assertEquals(INFINITY, costs[0]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);

    }
    @Test
    void simpleGraph2_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph2.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(5 , costs[1]);
        assertEquals(0, costs[0]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
    }
    @Test
    void simpleGraph2_AN_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph2.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(1, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(0 , costs[1]);
        assertEquals(INFINITY, costs[0]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
    }
    @Test
    void simpleGraph1_F(){
        Graph graph = new Graph("Input/PerformanceTests/graph2.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(5 , costs[0][1]);
        assertEquals(0, costs[0][0]);
        assertEquals(0, costs[1][1]);
        assertEquals(INFINITY, costs[1][0]);

        assertEquals(0, parents[0][0]);     //
        assertEquals(1, parents[0][1]);         //
    }

    // 3 nodes cycle strongly connected
    @Test
    void simpleGraph3_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertEquals(0, costs[0]);
        assertEquals(5 , costs[1]);
        assertEquals(8, costs[2]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void simpleGraph3_AN_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(1, costs, parents);

        assertEquals(7, costs[0]);
        assertEquals(0 , costs[1]);
        assertEquals(3, costs[2]);

        assertEquals(2, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void simpleGraph3_AN1_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(2, costs, parents);

        assertEquals(4, costs[0]);
        assertEquals(9 , costs[1]);
        assertEquals(0, costs[2]);

        assertEquals(2, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(-1, parents[2]);
    }
    @Test
    void simpleGraph3_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);

        assertTrue( NoNegCycle== true);

        assertEquals(0, costs[0]);
        assertEquals(5 , costs[1]);
        assertEquals(8, costs[2]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void simpleGraph3_AN_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(1, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(7, costs[0]);
        assertEquals(0 , costs[1]);
        assertEquals(3, costs[2]);

        assertEquals(2, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void simpleGraph3_AN1_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(2, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(4, costs[0]);
        assertEquals(9 , costs[1]);
        assertEquals(0, costs[2]);

        assertEquals(2, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(-1, parents[2]);
    }
    @Test
    void simpleGraph3_F(){
        Graph graph = new Graph("Input/PerformanceTests/graph3.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);

        assertTrue( NoNegCycle== true);

        assertEquals(0, costs[0][0]);
        assertEquals(5 , costs[0][1]);
        assertEquals(8, costs[0][2]);

//        assertEquals(-1, parents[0][0]);
//        assertEquals(0, parents[0][1]);
//        assertEquals(1, parents[0][2]);

        assertEquals(7, costs[1][0]);
        assertEquals(0 , costs[1][1]);
        assertEquals(3, costs[1][2]);

//        assertEquals(2, parents[1][0]);
//        assertEquals(-1, parents[1][1]);
//        assertEquals(1, parents[1][2]);

        assertEquals(4, costs[2][0]);
        assertEquals(9 , costs[2][1]);
        assertEquals(0, costs[2][2]);

//        assertEquals(2, parents[2][0]);
//        assertEquals(0, parents[2][1]);
//        assertEquals(-1, parents[2][2]);
    }

    // 3 nodes -ve cycles strongly connected
    @Test
    void simpleGraph4_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph4.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertEquals(0, costs[0]);
        assertEquals(3 , costs[1]);
        assertEquals(1, costs[2]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void simpleGraph4_AN_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph4.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(1, costs, parents);

        assertEquals(-6, costs[0]);
        assertEquals(0 , costs[1]);
        assertEquals(-2, costs[2]);

        assertEquals(2, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void simpleGraph4_AN1_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph4.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(2, costs, parents);

        assertEquals(-4, costs[0]);
        assertEquals(-1 , costs[1]);
        assertEquals(0, costs[2]);

        assertEquals(2, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(-1, parents[2]);
    }
    @Test
    void simpleGraph4_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph4.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);
        assertTrue( NoNegCycle==false);
    }
    @Test
    void simpleGraph4_F(){
        Graph graph = new Graph("Input/PerformanceTests/graph4.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);

        assertTrue( NoNegCycle== false);

    }

    // two disconnected graphs
    @Test
    void simpleGraph5_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertEquals(0, costs[0]);
        assertEquals(1 , costs[1]);
        assertEquals(INFINITY, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(INFINITY, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_AN_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(1, costs, parents);

        assertEquals(1, costs[0]);
        assertEquals(0, costs[1]);
        assertEquals(INFINITY, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(INFINITY, costs[4]);

        assertEquals(1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_AN1_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(2, costs, parents);

        assertEquals(INFINITY, costs[0]);
        assertEquals(INFINITY, costs[1]);
        assertEquals(0, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(INFINITY, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_AN2_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(3, costs, parents);

        assertEquals(INFINITY, costs[0]);
        assertEquals(INFINITY, costs[1]);
        assertEquals(1, costs[2]);
        assertEquals(0, costs[3]);
        assertEquals(1, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(3, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(3, parents[4]);
    }
    @Test
    void simpleGraph5_AN3_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(4, costs, parents);

        assertEquals(INFINITY, costs[0]);
        assertEquals(INFINITY, costs[1]);
        assertEquals(INFINITY, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(0, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);

        assertTrue( NoNegCycle== true);

        assertEquals(0, costs[0]);
        assertEquals(1 , costs[1]);
        assertEquals(INFINITY, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(INFINITY, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_AN_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(1, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(1, costs[0]);
        assertEquals(0, costs[1]);
        assertEquals(INFINITY, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(INFINITY, costs[4]);

        assertEquals(1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_AN1_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(2, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(INFINITY, costs[0]);
        assertEquals(INFINITY, costs[1]);
        assertEquals(0, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(INFINITY, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_AN2_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(3, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(INFINITY, costs[0]);
        assertEquals(INFINITY, costs[1]);
        assertEquals(1, costs[2]);
        assertEquals(0, costs[3]);
        assertEquals(1, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(3, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(3, parents[4]);
    }
    @Test
    void simpleGraph5_AN3_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(4, costs, parents);
        assertTrue( NoNegCycle== true);

        assertEquals(INFINITY, costs[0]);
        assertEquals(INFINITY, costs[1]);
        assertEquals(INFINITY, costs[2]);
        assertEquals(INFINITY, costs[3]);
        assertEquals(0, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(-1, parents[1]);
        assertEquals(-1, parents[2]);
        assertEquals(-1, parents[3]);
        assertEquals(-1, parents[4]);
    }
    @Test
    void simpleGraph5_F(){
        Graph graph = new Graph("Input/PerformanceTests/graph5.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);

        assertTrue( NoNegCycle== true);

        assertEquals(0, costs[0][0]);
        assertEquals(1 , costs[0][1]);
        assertEquals(INFINITY, costs[0][2]);
        assertEquals(INFINITY, costs[0][3]);
        assertEquals(INFINITY, costs[0][4]);

        assertEquals(1, costs[1][0]);
        assertEquals(0, costs[1][1]);
        assertEquals(INFINITY, costs[1][2]);
        assertEquals(INFINITY, costs[1][3]);
        assertEquals(INFINITY, costs[1][4]);

        assertEquals(INFINITY, costs[2][0]);
        assertEquals(INFINITY, costs[2][1]);
        assertEquals(0, costs[2][2]);
        assertEquals(INFINITY, costs[2][3]);
        assertEquals(INFINITY, costs[2][4]);

        assertEquals(INFINITY, costs[3][0]);
        assertEquals(INFINITY, costs[3][1]);
        assertEquals(1, costs[3][2]);
        assertEquals(0, costs[3][3]);
        assertEquals(1, costs[3][4]);

        assertEquals(INFINITY, costs[4][0]);
        assertEquals(INFINITY, costs[4][1]);
        assertEquals(INFINITY, costs[4][2]);
        assertEquals(INFINITY, costs[4][3]);
        assertEquals(0, costs[4][4]);
    }

    @Test
    void simpleGraph6_D(){
        Graph graph = new Graph("Input/PerformanceTests/graph6.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        graph.Dijkstra(0, costs, parents);

        assertEquals(0, costs[0]);
        assertEquals(8 , costs[1]);
        assertEquals(9, costs[2]);
        assertEquals(5, costs[3]);
        assertEquals(7, costs[4]);

    }
   @Test
    void simpleGraph6_B(){
        Graph graph = new Graph("Input/PerformanceTests/graph6.txt");
        int[] costs = new int[graph.size()];
        int[] parents = new int[graph.size()];
        boolean NoNegCycle = graph.BellmanFord(0, costs, parents);

        assertTrue( NoNegCycle== true);

       assertEquals(0, costs[0]);
       assertEquals(8 , costs[1]);
       assertEquals(9, costs[2]);
       assertEquals(5, costs[3]);
       assertEquals(7, costs[4]);
    }

    @Test
    void simpleGraph6_F(){
        Graph graph = new Graph("Input/PerformanceTests/graph6.txt");
        int[][] costs = new int[graph.size()][graph.size()];
        int[][] parents = new int[graph.size()][graph.size()];
        boolean NoNegCycle =  graph.floydWarshall(costs, parents);

        assertTrue( NoNegCycle== true);

        assertEquals(0, costs[0][0]);
        assertEquals(8 , costs[0][1]);
        assertEquals(9, costs[0][2]);
        assertEquals(5, costs[0][3]);
        assertEquals(7, costs[0][4]);
    }}
