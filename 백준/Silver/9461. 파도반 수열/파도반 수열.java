import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dynamic();

        for (int i = 1; i < N+1; i++) {
            System.out.println(dp[arr[i]]);
        }
    }

    static long[] dynamic(){
        dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < 101; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        return dp;
    }
}
