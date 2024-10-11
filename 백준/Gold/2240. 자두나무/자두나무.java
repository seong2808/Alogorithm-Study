import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int W;
    static int[] arr;
    static int[][][] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        T = Integer.parseInt(tk.nextToken());
        W = Integer.parseInt(tk.nextToken());

        arr = new int[T+1];
        for (int i = 1; i < T+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[T+1][W+2][3];

        for (int i = 1; i < T+1; i++) {
            for (int j = 1; j < W+2; j++) {
                if (arr[i] == 1) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]);
                } else {
                    if (i == 1 && j == 1) continue;
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < W+2; i++) {
            result = Math.max(result, Math.max(dp[T][i][1], dp[T][i][2]));
        }

        System.out.println(result);
    }
}
