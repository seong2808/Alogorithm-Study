import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] seq;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        seq = new int[M];

        bt(0);
        System.out.println(sb);
    }

    private static void bt(int dept) {
        if (dept == M) {
            for (int val : seq)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            seq[dept] = i + 1;
            bt(dept + 1);
        }
    }
}