import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int MOD = 1000000;
        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                if (str.charAt(0) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                dp[i] += dp[i-1];
                dp[i] %= MOD;

                int two = Integer.parseInt(str.substring(i-2, i));
                if (two > 10 && two <= 26 && two != 20) {
                    dp[i] += dp[i - 2];
                    dp[i] %= MOD;
                } else if (two == 10 || two == 20) {
                    dp[i] = dp[i-2] % MOD;
                }

                if (two / 10 > 2 && two % 10 == 0 || two == 0) {
                    dp[str.length()] = 0;
                    break;
                }
            }
        }

        System.out.println(dp[str.length()]);
    }
}


