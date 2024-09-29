import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());

        dp = new Integer[n+1];
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(recur(n));
    }

    static int recur(int n) {
        if (dp[n] == null) {
            if (n==2) return 2;
            dp[n] = (recur(n-1) + recur(n-2)) % 10007;
        }
        return dp[n];
    }
}