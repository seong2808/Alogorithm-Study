import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        int[] dp = new int[N + 1];

        int result = 1;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N + 1; i++) {
            if (i == 0 || i == 1)
                dp[i] = 1;
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        if (M == 0) {
            System.out.println(dp[N]);
        } else {
            for (int i = 0; i < M+1; i++) {
                int divided = 0;
                if (i == 0) {
                    divided = arr[i] - 1;
                } else if (i == M) {
                    divided = N - arr[i-1];
                } else {
                    divided = arr[i] - arr[i - 1] - 1;
                }

                result *= dp[divided];
            }

            System.out.println(result);
        }
    }
}
