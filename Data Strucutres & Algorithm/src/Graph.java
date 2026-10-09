import java.util.*;

public class Graph {

    static int n;
    static String[] labels;
    static int[][] adjMatrix;
    static List<List<Integer>> adjList = new ArrayList<>();

    // Returns the index of a label, or -1 if not found
    static int indexOf(String label) {
        for (int i = 0; i < n; i++) {
            if (labels[i].equalsIgnoreCase(label)) return i;
        }
        return -1;
    }

    static void addEdge(int u, int v) {
        // Undirected graph: store both directions
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    static void displayMatrix() {
        System.out.println("\n=== Adjacency Matrix ===");
        System.out.print("    ");
        for (int i = 0; i < n; i++) System.out.print(labels[i] + "  ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(labels[i] + " | ");
            for (int j = 0; j < n; j++) System.out.print(adjMatrix[i][j] + "  ");
            System.out.println();
        }
    }

    static void displayList() {
        System.out.println("\n=== Adjacency List ===");
        for (int i = 0; i < n; i++) {
            System.out.print(labels[i] + " -> ");
            List<Integer> neighbors = adjList.get(i);
            for (int k = 0; k < neighbors.size(); k++) {
                System.out.print(labels[neighbors.get(k)]);
                if (k < neighbors.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.append(labels[current]).append(" ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("\n=== BFS Traversal (start: " + labels[start] + ") ===");
        System.out.println(order.toString().trim().replace(" ", " -> "));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Number of vertices
        System.out.print("Enter the number of vertices: ");
        n = Integer.parseInt(sc.nextLine().trim());

        adjMatrix = new int[n][n];
        labels = new String[n];
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // 2. Vertex labels
        System.out.println("Enter the vertex labels:");
        for (int i = 0; i < n; i++) {
            System.out.print("  Vertex " + (i + 1) + ": ");
            labels[i] = sc.nextLine().trim();
        }

        // 3. Edges
        System.out.print("Enter the number of edges: ");
        int e = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Enter each edge as two labels (e.g., A B):");
        for (int i = 0; i < e; i++) {
            System.out.print("  Edge " + (i + 1) + ": ");
            String[] parts = sc.nextLine().trim().split("\\s+");
            if (parts.length != 2) {
                System.out.println("  Invalid input. Enter two labels separated by a space.");
                i--;
                continue;
            }
            int u = indexOf(parts[0]);
            int v = indexOf(parts[1]);
            if (u == -1 || v == -1) {
                System.out.println("  Unknown vertex label. Try again.");
                i--;
                continue;
            }
            addEdge(u, v);
        }

        // 6 & 7. Display both representations
        displayMatrix();
        displayList();

        // 8. Starting vertex
        int start;
        while (true) {
            System.out.print("\nEnter the starting vertex: ");
            start = indexOf(sc.nextLine().trim());
            if (start != -1) break;
            System.out.println("Vertex not found. Try again.");
        }

        // 9 & 10. BFS and display traversal
        bfs(start);

        sc.close();
    }
}