import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        arr = new int[N];
        dp = new int[K+1];
        dp[0] = 1;
        
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j < K+1; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[K]);
    }

}
