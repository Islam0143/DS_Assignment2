package Graph;

public class Vertex {
    public int value;
    public int cost;
    public Vertex(int value, int cost) {
        this.value = value;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}