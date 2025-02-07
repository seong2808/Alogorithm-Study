import java.io.*;
import java.util.*;

class Graph {
    class Node {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        Node(int data) {
            this.data = data;
            marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    int[] visited;
    int cnt;
    Graph(int size) {
        nodes = new Node[size];
        visited = new int[size];
        cnt = 1;
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i+1);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1 - 1];
        Node n2 = nodes[i2 - 1];

//        if (!n1.adjacent.contains(n2)) {
//            n1.adjacent.add(n2);
//        }
//        if (!n2.adjacent.contains(n1)) {
//            n2.adjacent.add(n1);
//        }

        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
    }

    void dfs(int index) {
        Node r = nodes[index-1];
        dfs(r);
    }

    void dfs(Node r) {
        if (r == null) return;
        sort(r);
        r.marked = true;
        visited[r.data - 1] = cnt;
        cnt++;
        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfs(n);
            }
        }


    }

    void sort(Node r) {
        Collections.sort(r.adjacent, (o1, o2) -> {
            return o2.data - o1.data;
        });
    }
}

public class Main {
    private static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(tk.nextToken());
            int i2 = Integer.parseInt(tk.nextToken());
            g.addEdge(i1, i2);
        }

        g.dfs(K);
        int[] result = g.visited;
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }

    }
}