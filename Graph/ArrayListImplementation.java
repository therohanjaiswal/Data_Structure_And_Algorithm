import java.util.ArrayList;

class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public void printGraph() {
        for (int i = 0; i < adj.size(); ++i) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adj.get(i).size(); ++j)
                System.out.print(adj.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        Graph adj = new Graph(v);
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(1, 2);
        adj.addEdge(1, 3);
        adj.printGraph();
    }
}