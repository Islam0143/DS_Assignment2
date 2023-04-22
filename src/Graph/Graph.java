package Graph;

import java.io.File;
import java.util.*;

public class Graph {

    private ArrayList<Edge>[] adjacencyList;
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
        adjacencyList[from].add(new Edge(to, weight));
    }

    public void Dijkstra(int src, int[] costs, int[] parents) {
        Arrays.fill(costs, INFINITY);
        costs[src] = 0;
        Arrays.fill(parents, -1);
        boolean visited [] = new boolean[size];
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparing(Vertex::getCost));
        pq.offer(new Vertex(src , 0));
        while( !pq.isEmpty()) {
            Vertex u = pq.poll();
            if(u.cost > costs[u.value]) {continue;}
            visited[u.value] = true;
            for( Edge edge : adjacencyList[u.value]){
                int v = edge.to;;
                if(visited[v]) {continue;}
                if(costs[v] < (u.cost + edge.weight)) {
                    parents[v] = u.value;
                    costs[v] = (u.cost + edge.weight);
                    pq.offer(new Vertex(v , costs[v]));
                }
            }
        }
    }

    public boolean BellmanFord(int src, int[] costs, int[] parents) {
        Arrays.fill(costs, INFINITY);
        costs[src] = 0;
        Arrays.fill(parents, -1);         //-1 indicates null
        for(int k = 0; k < size -1; k++) {      //n-1 iterations
            for(int i = 0; i < size; i++) {
                for(Edge edge: adjacencyList[i]) {      //for each edge
                    if(costs[i] != INFINITY && costs[i] + edge.weight < costs[edge.to]) {
                        costs[edge.to] = costs[i] + edge.weight;
                        parents[edge.to] = i;
                    }
                }
            }
        }
        //detect negative cycle
        for(int i = 0; i < size; i++)
            for(Edge edge: adjacencyList[i])       //for each edge
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