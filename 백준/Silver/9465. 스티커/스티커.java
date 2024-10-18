import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(tk.nextToken());
        int[] result = new int[T];

        for (int k = 0; k < T; k++) {
            tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(tk.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    if (i == 0) {
                        dp[j][0] = arr[j][0];
                    } else if (i == 1) {
                        if (j == 0) {
                            dp[j][i] = dp[1][0] + arr[j][i];
                        } else {
                            dp[j][i] = dp[0][0] + arr[j][i];
                        }
                    } else {
                        if (j == 0) {
                            dp[j][i] = Math.max(dp[j][i - 2], Math.max(dp[j + 1][i - 2], dp[j + 1][i - 1])) + arr[j][i];
                        } else {
                            dp[j][i] = Math.max(dp[j][i - 2], Math.max(dp[j - 1][i - 2], dp[j - 1][i - 1])) + arr[j][i];
                        }
                    }
                }
            }

            result[k] = Math.max(dp[0][N - 1], dp[1][N - 1]);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }
}
