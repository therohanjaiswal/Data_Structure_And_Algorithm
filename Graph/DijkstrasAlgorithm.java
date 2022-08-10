
// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
import java.util.*;

class Graph {
    int size;
    ArrayList<ArrayList<Node>> adj;

    public Graph(int n) {
        this.size = n;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
        adj.get(v).add(new Node(u, weight));
    }

    void addEdgeDirected(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
    }

    void print() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + "->");
            for (Node e : adj.get(i)) {
                System.out.print(e.node + "," + e.dist + " ->");
            }
            System.out.println();
        }
    }

    // TC: O((V + E)logV), SC: O(V + E)
    public int[] dijkstras(int V, Graph graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(src, 0));

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.remove();
            int u = curr.node;
            for (Node v : adj.get(u)) {
                if (dist[v.node] > dist[u] + v.dist) {
                    dist[v.node] = dist[u] + v.dist;
                    minHeap.add(new Node(v.node, dist[v.node]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of vertices in the graph: ");
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        System.out.println("Enter the number of Edges");
        int e = sc.nextInt();
        System.out.println("Enter u v  and weight for the edges");
        Graph graph = new Graph(V);
        for (int i = 1; i <= e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(u, v, weight);
        }

        System.out.println("Enter source: ");
        int src = sc.nextInt();

        int[] dist = graph.dijkstras(V, graph, src);
        for (int i = 0; i < V; ++i)
            System.out.println("Distance of " + i + " from source " + src + ": " + dist[i]);
    }
}

// For min heap, Node represents vertex and it's distance from source
// For List<List<Node>>, Node represents edge to v and it's weight.
class Node implements Comparable<Node> {
    int node;
    int dist;

    public Node(int n, int d) {
        node = n;
        dist = d;
    }

    public int compareTo(Node n) {
        return this.dist - n.dist;
    }
}
