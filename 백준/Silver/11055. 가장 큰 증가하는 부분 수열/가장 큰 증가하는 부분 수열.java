import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N+1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int[] dp = new int[N+1];
        int maxSum = Integer.MIN_VALUE;
        dp[0] = arr[0];

        for (int i = 0; i < N+1; i++) {
            for (int  j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}

