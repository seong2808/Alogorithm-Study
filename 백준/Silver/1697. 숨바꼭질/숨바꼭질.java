import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        System.out.println(bfs(N));
    }

    private static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int idx = N, n = 0;
        visited[idx] = 1;
        while (!queue.isEmpty()) {
            n = queue.remove();

            if (n == K) {
                return visited[n] - 1;
            }
            if (n-1>=0 && visited[n-1] == 0)
            {
                visited[n-1] = visited[n]+1;
                queue.add(n-1);
            }
            if (n+1 <= 100000 && visited[n+1] == 0)
            {
                visited[n+1] = visited[n]+1;
                queue.add(n+1);
            }
            if (2*n <= 100000 && visited[2*n] == 0)
            {
                visited[2*n] = visited[n] + 1;
                queue.add(2*n);
            }
        }
        return -1;
    }
}