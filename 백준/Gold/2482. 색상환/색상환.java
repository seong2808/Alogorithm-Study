import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int MOD = 1000000003;

        if (N / 2 < K)
            System.out.println(0);
        else {
            int[][] dp = new int[N + 1][K + 1];

            for (int i = 1; i <= N; i++) {
                dp[i][0] = 1;
                dp[i][1] = i;
            }

            for (int i = 3; i <= N; i++) {
                for (int j = 2; j <= (i+1)/2 ; j++) {
                    if (j > K)
                        break;
                    dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
                }
            }

            System.out.println((dp[N-3][K-1] + dp[N-1][K]) % MOD);
        }
    }
 }




