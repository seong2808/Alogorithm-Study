import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());

        dp = new Long[n+1];
        dp[0] = 0L;
        dp[1] = 1L;

        System.out.println(recur(n));
    }

    static long recur(int n) {
        if (dp[n] == null) {
            dp[n] = recur(n-1) + recur(n-2);
        }
        return dp[n];
    }
}