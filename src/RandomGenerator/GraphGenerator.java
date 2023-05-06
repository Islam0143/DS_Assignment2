package RandomGenerator;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


//----------this class after the ith execution creates a file called graphi with random graph nodes and edges---------//
public class GraphGenerator {
    public static void main(String[] args) {
        Random random = new Random();
        /*int V = random.nextInt(101);
        int E = random.nextInt(V*(V-1)/2);*/
        int V = 250;
        int E = 20000;


        Set<String> edgeSet = new HashSet<>();

        try {
            File file = new File("Input/number.txt");
            Scanner sc = new Scanner(file);
            int i = sc.nextInt();
            sc.close();

            FileWriter writer1 = new FileWriter(file);
            writer1.write(Integer.toString(i+1));
            writer1.close();

            FileWriter writer2 = new FileWriter("Input/graph" + i + ".txt");
            writer2.write(V + " " + E + "\n");
            while (edgeSet.size() < E) {
                int u = random.nextInt(V); // source vertex
                int v = random.nextInt(V); // destination vertex
                if (u == v || edgeSet.contains(u + " " + v)) continue;
                int w = (int)Math.floor(random.nextGaussian() * 8 + 20);   //mean = 20, std dev = 8
                //if(random.nextDouble() < 0.03) w = random.nextInt(1)-8;      //negative weights with probability 3%
                if(w < 0) w = -w;
                edgeSet.add(u + " " + v);
                String edge = u + " " + v + " " + w;
                writer2.write(edge + "\n");
            }
            System.out.println("file graph"+i+" was created");
            writer2.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}