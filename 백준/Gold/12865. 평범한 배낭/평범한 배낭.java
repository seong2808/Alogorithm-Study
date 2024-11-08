import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        int[][] arr = new int[N+1][2];
        int[][] dp = new int[K+1][N+1];

        for (int i = 1; i < N+1; i++) {
            tk = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if (arr[i][0] > j)
                    dp[j][i] = dp[j][i-1];
                else
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j - arr[i][0]][i - 1] + arr[i][1]);
            }
        }
        System.out.println(dp[K][N]);



    }
}


