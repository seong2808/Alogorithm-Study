import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static int result = 0;
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        visited = new boolean[N];
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i= 0; i < N; i++) {
            if (result != 1)
                dfs(i, 1);
        }

        System.out.println(result);
    }

    public static void dfs(int s, int d) {
        if (d == 5) {
            result = 1;
            return;
        }

        visited[s] = true;
        for (int b : list[s]) {
            if (!visited[b])
                dfs(b, d + 1);
        }
        visited[s] = false;
    }
}
