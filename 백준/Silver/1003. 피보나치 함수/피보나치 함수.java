import java.util.Scanner;

public class Main {
    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N];
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            maxNum = Math.max(maxNum, arr[i]);
        }

        dp = new Integer[maxNum+1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        
        if (maxNum > 0) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }
        
        fibonacci(maxNum);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(dp[arr[i]][0]+" "+ dp[arr[i]][1]);
        }

    }

    static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }
}