import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[] dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 1;
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-3]) + 1;
            }
        }

        System.out.println(dp[N] % 2 == 0 ? "CY" : "SK");
        
    }
}


