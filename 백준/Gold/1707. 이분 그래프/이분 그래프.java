import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int K, V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            V = Integer.parseInt(str[0]);
            E = Integer.parseInt(str[1]);

            graph = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                String[] edges = br.readLine().split(" ");
                int v1 = Integer.parseInt(edges[0]) - 1;
                int v2 = Integer.parseInt(edges[1]) - 1;

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            boolean isBipartite = bfs();
            if (isBipartite) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        int[] color = new int[V];
        color[0] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer i : graph.get(cur)) {
                if (color[i] == 0) {
                    if (color[cur] == 0) color[cur] = 1;
                    color[i] = color[cur] * -1;
                    queue.add(i);
                } else if (color[i] == color[cur]) {
                    return false;
                }
            }

            if (queue.isEmpty() && cur < V-1) {
                queue.add(++cur);
            }
        }
        return true;
    }
}