
// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
import java.lang.reflect.Array;
import java.util.*;

// graph should be weighted connected and undirected
// can't find mst for disconnected or directed graph
class Graph {
    int size;
    ArrayList<ArrayList<Node>> adj;

    Graph(int n) {
        this.size = n;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
        adj.get(v).add(new Node(u, weight));
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

    // TC: O(V^2), SC: O(V)
    int findMSTNaive(int V, Graph graph) {
        int mstWeight = 0;
        int[] parent = new int[V];
        int[] key = new int[V]; // stores distance of ith node
        boolean[] mSet = new boolean[V]; // true means ith node has been included in mst
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;
        parent[0] = -1;

        int minKeyVertex = -1;
        for (int count = 0; count < V; ++count) {
            // getMinKey() gives me an unvisited node with least edge weight
            minKeyVertex = getMinKey(V, key, mSet);
            mSet[minKeyVertex] = true;
            mstWeight += key[minKeyVertex];
            for (Node v : adj.get(minKeyVertex)) {
                if (!mSet[v.node] && v.dist < key[v.node]) {
                    key[v.node] = v.dist;
                    parent[v.node] = minKeyVertex;
                }
            }
        }

        return mstWeight;
    }

    int getMinKey(int V, int[] key, boolean[] mSet) {
        int minKeyIndex = -1, minKeyValue = Integer.MAX_VALUE;
        for (int i = 0; i < V; ++i) {
            // i should be unvisited and min dist
            if (!mSet[i] && key[i] < minKeyValue) {
                minKeyValue = key[i];
                minKeyIndex = i;
            }
        }
        return minKeyIndex;
    }

    // TC: O(ElogV), SC: O(V + E)
    int findMSTValueEfficient(int V, Graph graph) {
        int mstWeight = 0;
        int[] parent = new int[V];
        int[] key = new int[V]; // stores distance of ith node
        boolean[] mSet = new boolean[V]; // true means ith node has been included in
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        key[0] = 0;
        parent[0] = -1;
        minHeap.add(new Node(0, key[0]));

        for (int count = 0; count < V; ++count) {
            Node curr = minHeap.remove();
            int u = curr.node;
            mSet[u] = true;
            mstWeight += curr.dist;
            for (Node v : adj.get(u)) {
                if (!mSet[v.node] && v.dist < key[v.node]) {
                    key[v.node] = v.dist;
                    parent[v.node] = u;
                    minHeap.add(new Node(v.node, key[v.node]));
                }
            }
        }

        return mstWeight;
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

        System.out.println(graph.findMSTNaive(V, graph));
        System.out.println(graph.findMSTValueEfficient(V, graph));
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
