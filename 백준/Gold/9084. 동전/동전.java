import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dp;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(tk.nextToken());
        result = new int[T];

        for (int i = 0; i < T; i++) {
            tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            arr = new int[N];

            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
            }

            tk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(tk.nextToken());

            dp = new int[M + 1];
            dp[0] = 1;
            for (int j = 0; j < N; j++) {
                for (int k = arr[j]; k < M+1; k++) {
                    dp[k] += dp[k-arr[j]];
                }
            }

            result[i] = dp[M];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }

    }
}
