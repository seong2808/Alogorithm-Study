import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        
        if (n == 1 && m == 1) {
            System.out.println(1);
        } else {
            dp = new int[n+1][m+1];
            int low = 0;


            for (int i = 1; i < n+1; i++) {
                String[] nums = br.readLine().split("");
                for (int j = 1; j < m+1; j++) {
                    int num = Integer.parseInt(nums[j-1]);

                    if (i == 1 && j == 1) {
                        dp[i][j] = num;
                    } else {
                        if (num == 1) {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                            low = Math.max(low, dp[i][j]);
                        }
                    }

                }
            }

            System.out.println(low*low);
        }
    }
}
