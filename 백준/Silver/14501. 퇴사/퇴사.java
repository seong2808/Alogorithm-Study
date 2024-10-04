import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());

        int[][] arr = new int[N+1][2];

        for (int i = 1; i < N+1; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
        }

        int[] dp = new int[N+1];
        int maxSum = 0;

        for (int i = 0; i < N+1; i++) {
            for (int  j = 0; j < i; j++) {
                if (arr[j][0] <= i-j && arr[i][0] <= N+1-i)
                    dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);

    }
}
