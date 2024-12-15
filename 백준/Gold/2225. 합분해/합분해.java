import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int MOD = 1000000000;

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i == 1)
                    dp[i][j] = j;
                else if (j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] =  (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}