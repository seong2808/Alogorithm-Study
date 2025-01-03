import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int n = Integer.parseInt(br.readLine());
        visited = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            putEdge(graph, a, b);
        }

        bfs();

        System.out.println(result);
    }

    private static void putEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1]++;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            if (visited[v] >= 3) {
                break;
            }

            for (int i = 0; i < graph.get(v).size(); i++) {
                if (visited[graph.get(v).get(i)] == 0) {
                    visited[graph.get(v).get(i)] = visited[v] + 1;
                    queue.add(graph.get(v).get(i));
                    result++;
                }
            }
        }
    }
}