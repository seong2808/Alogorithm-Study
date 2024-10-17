import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];

        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[N]);
    }

}
