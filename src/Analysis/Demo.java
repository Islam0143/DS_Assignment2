package Analysis;

import Graph.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int numberOfGraphs = 25;
        // ----------------------- Separator -----------------------
        String workingDir = System.getProperty("user.dir") + "/Input/AnalysisGraphs/" + "graph1.txt";
        ArrayList<String> graphSet = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();
        ArrayList<Integer> edges = new ArrayList<>();
        for(int i = 1 ; i <= 20 ; i++)
            graphSet.add(workingDir.replace("graph1.txt", "graph" + i + ".txt"));
        // ----------------------- Separator -----------------------
        ArrayList<ArrayList<ArrayList<Long>>> analysisOutput = new ArrayList<ArrayList<ArrayList<Long>>>();
        for(String tempGraph : graphSet) {
            Graph g = new Graph(tempGraph);
            sizes.add(g.getSize());edges.add(g.getNumberOfEdges());
            ArrayList<ArrayList<Long>> algorithmsOutput = new ArrayList<ArrayList<Long>>();
            for (int i = 0; i < 3; i++) {
                ArrayList<Long> tempOutput = new ArrayList<Long>();
                // ----------------------- All 2 pairs time -----------------------
                long start = System.nanoTime();
                switch (i) {
                    case 0 -> g.dijkstraAllPairs();
                    case 1 -> g.bellmanAllPairs();
                    case 2 -> {
                        int[][] costs = new int[g.getSize()][g.getSize()];
                        int[][] predecessors = new int[g.getSize()][g.getSize()];
                        g.floydWarshall(costs, predecessors);
                    }
                }
                long end = System.nanoTime();
                tempOutput.add((end - start) / 1000);
                // ----------------------- Specific 2 nodes time -----------------------
                int[][] costs = new int[g.getSize()][g.getSize()];
                int[][] parents = new int[g.getSize()][g.getSize()];
                start = System.nanoTime();
                for (int m = 0; m < g.getSize(); m++) {
                    switch (i) {
                        case 0 -> g.Dijkstra(m, costs[m], parents[m]);
                        case 1 -> g.BellmanFord(m, costs[m], parents[m]);
                        case 2 -> {
                            //g.floydWarshall(costs, parents);
                        }
                    }
                }
                end = System.nanoTime();
                tempOutput.add(((end - start) / g.getSize()) / 1000);
                // ----------------------- Separator -----------------------
//                long avg = 0;
//                for (int p = 1; p < tempOutput.size(); p++)
//                    avg += tempOutput.get(p);
//                avg /= (tempOutput.size() - 1);
//                ArrayList<Long> tempList = new ArrayList<>();
//                tempList.add(tempOutput.get(0) / 1000);      // in micro
//                tempList.add(avg / 1000);       // in micro
                // ----------------------- Separator -----------------------
                algorithmsOutput.add(tempOutput);
            }
            analysisOutput.add(algorithmsOutput);
        }
        // ----------------------- Separator -----------------------
        // Print To Google Sheet Format
        // Dijkstra All 2 Pairs Time, Dijkstra Specific 2 Pairs mean time,
        // etc ..
        int r = 0;
        for(ArrayList<ArrayList<Long>> tempOutput : analysisOutput){
            System.out.println(
                    sizes.get(r) + "\t" + edges.get(r++) + "\t" +
                    tempOutput.get(0).get(0) + "\t" + tempOutput.get(0).get(1) + "\t" +
                    tempOutput.get(1).get(0) + "\t" + tempOutput.get(1).get(1) + "\t" +
                    tempOutput.get(2).get(0) + "\t" + tempOutput.get(2).get(1) + "\t"
            );
        }
        // ----------------------- Separator -----------------------
//        for(ArrayList<ArrayList<Long>> tempOutput : analysisOutput){
//            System.out.println("Graph Output: Algorithm [All 2 Pairs Time in Micro S, Avg Time for Specific Pairs in Micro S]");
//            System.out.print("\t");
//            System.out.print("Dijkstra's Output: ");
//            System.out.println(tempOutput.get(0).toString());
//            System.out.print("\t");
//            System.out.print("Bellman's Output: ");
//            System.out.println(tempOutput.get(1).toString());
//            System.out.print("\t");
//            System.out.print("Floyd-Warshall's Output: ");
//            System.out.println(tempOutput.get(2).toString());
//        }
        // ----------------------- Separator -----------------------





    }
}

/*
 * Graph1:
 *      Algorithm1: all2Pairs 2Node 2Node 2Node 2Node 2Node
 *      Alg 2:
 * Graph2: etc ..
 */
