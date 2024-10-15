import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N];
        int max = 0;
        long MOD = 1000000009;


        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(tk.nextToken());
            max = Math.max(arr[i], max);
        }

        if (max > 3) {
            long[] dp = new long[max + 1];

            dp[1] = 1 % MOD;
            dp[2] = 2 % MOD;
            dp[3] = 4 % MOD;

            for (int i = 4; i < max + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
            }

            for (int i = 0; i < N; i++) {
                System.out.println(dp[arr[i]]);
            }
        } else {
            long[] dp = new long[4];

            dp[1] = 1 % MOD;
            dp[2] = 2 % MOD;
            dp[3] = 4 % MOD;

            for (int i = 0; i < N; i++) {
                System.out.println(dp[arr[i]]);
            }
        }
    }
}
