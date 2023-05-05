package Graph;

import java.io.File;
import java.util.*;

public class Graph {

    private ArrayList<Edge>[] adjacencyList;
    int[][] edges;
    private int size;
    private static final Integer INFINITY = Integer.MAX_VALUE / 3;
    private boolean negCycleFlag = true;
    private int numberOfEdges;

    public Graph(String filePath) {
        try {
            File myFile = new File(filePath);
            Scanner scanner = new Scanner(myFile);
            size = scanner.nextInt();      //# vertices
            int E = scanner.nextInt();      //# edges
            this.numberOfEdges = E;
            adjacencyList = new ArrayList[size];
            edges = new int[E][3];
            for(int i = 0; i < size; i++) adjacencyList[i] = new ArrayList<>();
            for(int i = 0; i < E; i++) {
                int[] edge = new int[3];
                edge[0] = scanner.nextInt();
                edge[1] = scanner.nextInt();
                edge[2] = scanner.nextInt();
                edges[i] = edge;
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
        boolean[] visited = new boolean[size];
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparing(Vertex::getCost));
        pq.offer(new Vertex(src , 0));
        while( !pq.isEmpty()) {
            Vertex u = pq.poll();
            if(u.cost > costs[u.value]) {continue;}
            visited[u.value] = true;
            for( Edge edge : adjacencyList[u.value]){
                int v = edge.to;
                if(visited[v]) {continue;}
                if(costs[u.value] != INFINITY && (costs[u.value] + edge.weight) < costs[v]) {
                    parents[v] = u.value;
                    costs[v] = (costs[u.value] + edge.weight);
                    pq.offer(new Vertex(v , costs[v]));
                }
            }
        }
    }

    public void dijkstraAllPairs(){
        for(int i = 0 ; i < getSize() ; i++){
            int[] tempCosts = new int[getSize()];
            int[] tempParents = new int[getSize()];
            Dijkstra(i, tempCosts, tempParents);
        }
    }

    public boolean BellmanFord(int src, int[] costs, int[] parents) {
        Arrays.fill(costs, INFINITY);
        costs[src] = 0;
        Arrays.fill(parents, -1);         //-1 indicates null
        for(int k = 0; k < size -1; k++) {      //n-1 iterations
            for(int[] edge: edges) {          //for each edge
                if (costs[edge[0]] != INFINITY && costs[edge[0]] + edge[2] < costs[edge[1]]) {
                    costs[edge[1]] = costs[edge[0]] + edge[2];
                    parents[edge[1]] = edge[0];
                }
            }
        }
        //detect negative cycle
        for(int[] edge: edges)           //for each edge
            if (costs[edge[0]] != INFINITY && costs[edge[0]] + edge[2] < costs[edge[1]])
                return false;
        return true;
    }

    public void bellmanAllPairs(){
        for(int i = 0 ; i < getSize() ; i++){
            int[] tempCosts = new int[getSize()];
            int[] tempParents = new int[getSize()];
            BellmanFord(i, tempCosts, tempParents);
        }
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

    public boolean floydWarshall(int[][] costs, int[][] predecessors){
        // If the costs' matrix is not initialized yet run the following
        if(costs == null)
            costs = new int[size][size];
        if(predecessors == null)
            predecessors = new int[size][size];
        // ----------------------- Separator -----------------------
        boolean negCycleFlag = true;
        // ----------------------- Separator -----------------------
        init_floydWarshallCosts(costs, predecessors);
        // ----------------------- Separator -----------------------
        for(int k = 0 ; k < size ; k++)
            for(int i = 0 ; i < size ; i++)
                for(int j = 0 ; j < size ; j++) {
                    if(costs[i][j] > costs[i][k] + costs[k][j] && costs[i][k] != INFINITY && costs[k][j] != INFINITY){
                        costs[i][j] = costs[i][k] + costs[k][j];
                        predecessors[i][j] = predecessors[i][k];
                    }
                }
        // ----------------------- Separator -----------------------
        for(int i = 0 ; i < size ; i++)
            if(costs[i][i] < 0) {
                negCycleFlag = false;
                break;
            }
        // ----------------------- Separator -----------------------
//        System.out.println("Final Costs:");
//        display_adjacencyMatrix(costs);
//        System.out.println();
//        System.out.println("Final Predecessors:");
//        display_adjacencyMatrix(predecessors);
        this.negCycleFlag = negCycleFlag;
        return negCycleFlag;
    }

    public void init_floydWarshallCosts(int[][] costs, int[][] predecessors){     // costs is the adjacency matrix
        for(int i = 0 ; i < size ; i++) {
            Arrays.fill(costs[i], INFINITY);
            costs[i][i] = 0;
        }
        int currentNode = 0;
        for(ArrayList<Edge> tempList : adjacencyList){
            for(Edge edge : tempList)
                costs[currentNode][edge.to] = edge.weight;
            currentNode++;
        }
        // ----------------------- Separator -----------------------
        for(int i = 0 ; i < size ; i++)
            for(int j = 0 ; j < size ; j++) {
                if (i == j)
                    predecessors[i][j] = 0;
                if (costs[i][j] != INFINITY)
                    predecessors[i][j] = j;
                else
                    predecessors[i][j] = -1;
            }
    }

    public void display_adjacencyMatrix(int[][] costs){
        for(int i = 0 ; i < size ; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(costs[i][j] + " ");
            System.out.println();
        }
    }

    public boolean invalidGraph(){
        return !this.negCycleFlag;
    }

    public int getSize(){
        return this.size;
    }

    public int getNumberOfEdges() {return this.numberOfEdges;}
}