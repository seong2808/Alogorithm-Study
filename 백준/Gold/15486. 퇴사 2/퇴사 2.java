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

        int[] dp = new int[N+2];
        int maxSum = 0;
        int time = 0;
        int sum = 0;

        for (int i = 1; i < N+1; i++) {
            if (i + arr[i][0] - 1 <= N) {
                dp[i + arr[i][0] - 1] = Math.max(dp[i + arr[i][0] - 1], dp[i-1] + arr[i][1]);
            }
            
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        System.out.println(dp[N]);

    }
}
