import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (j == 1) {
                    dp[i][j] = i;
                } else if (i == 0) {
                  dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}