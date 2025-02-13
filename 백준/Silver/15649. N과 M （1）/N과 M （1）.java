import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        visited = new boolean[N + 1];
        seq = new int[M];

        bt(0);
    }
    
    private static void bt(int index) {
        if (index == M) {
            for (int val : seq)
                System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[index] = i;
                bt(index + 1);
                visited[i] = false;
            }
        }
    }
}