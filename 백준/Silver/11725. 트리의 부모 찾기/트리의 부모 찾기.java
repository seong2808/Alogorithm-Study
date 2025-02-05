import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> t = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            t.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] str = br.readLine().split(" ");
            int n1 = Integer.parseInt(str[0]) - 1;
            int n2 = Integer.parseInt(str[1]) - 1;
            t.get(n1).add(n2);
            t.get(n2).add(n1);
        }

        boolean[] visited = new boolean[N];
        int[] parentNode = new int[N];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int node : t.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    parentNode[node] = v;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            System.out.println(parentNode[i] + 1);
        }
    }
}