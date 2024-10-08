import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Long[][] dp;
    static int N;
    static long MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        dp = new Long[N + 1][10];


        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i < 10; i++) {
            result += recur(N, i);
        }

        System.out.println(result % MOD);

    }

    static long recur(int digit, int currentNum) {
        if (digit == 1) {
            return dp[digit][currentNum];
        }

        if (dp[digit][currentNum] == null) {
            if (currentNum == 0)
                dp[digit][currentNum] = recur(digit - 1, 1);
            else if (currentNum == 9)
                dp[digit][currentNum] = recur(digit - 1, 8);
            else
                dp[digit][currentNum] = recur(digit - 1, currentNum - 1) + recur(digit - 1, currentNum + 1);
        }
        return dp[digit][currentNum] % MOD;
    }
}
