import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] result, seq;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(tk.nextToken());
        seq = new int[N];
        M = Integer.parseInt(tk.nextToken());
        result = new int[M];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(seq);


        bt(0,0);
        System.out.println(sb);
    }

    private static void bt(int index, int dept) {
        if (dept == M) {
            for (int val : result)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = index; i < N; i++) {
            result[dept] = seq[i];
            bt(i,dept + 1);
        }
    }
}