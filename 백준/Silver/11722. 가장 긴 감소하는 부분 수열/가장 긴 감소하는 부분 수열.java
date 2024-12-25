import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            seq[i] = Integer.parseInt(tk.nextToken());
            dp[i] = 1;
        }

        dp[0] = seq[0];
        int maxLen = 0;
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] < seq[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}
