import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());

        dp = new Integer[n+1];
        dp[0] = dp[1] = 1;

        System.out.println(recur(n));
    }

    static int recur(int n) {
        if (dp[n] == null) {
            if (n==2) return 3;
            dp[n] = (recur(n-1) + recur(n-2)*2) % 10007;
        }
        return dp[n];
    }
}