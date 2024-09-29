import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());

        arr = new int[n*3+1];
        for (int i=1;i < n*3+1; i++) {
            if (i % 3 == 1) {
                tk = new StringTokenizer(br.readLine());
            }
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dp = new Integer[n*3+1];
        dp[0] = arr[0];

        System.out.println(Math.min(Math.min(recur(n*3), recur(n*3-1)), recur(n*3-2)));
    }

    static int recur(int n) {
        if (dp[n] == null) {
            if (n / 3 == 0 || n / 3 == 1 && n % 3 == 0) {
                dp[n] = arr[n];
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n-4), recur(n-5)) + arr[n];
            } else if (n % 3 == 1) {
                dp[n] = Math.min(recur(n - 1), recur(n - 2)) + arr[n];
            } else {
                dp[n] = Math.min(recur(n - 2), recur(n - 4)) + arr[n];
            }
        }
        return dp[n];
    }
}