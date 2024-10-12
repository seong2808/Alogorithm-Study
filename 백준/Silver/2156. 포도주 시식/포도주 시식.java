import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];


        for (int i = 1; i < N+1; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        int maxSum = dp[1];
        for (int i = 2; i < N+1; i++) {
            if (i > 2) {
                dp[i] = Math.max(dp[i-2]+ arr[i], Math.max(dp[i-3] + arr[i-1]+ arr[i], dp[i-1]));
            } else {
                dp[i] = dp[i - 1] + arr[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}
