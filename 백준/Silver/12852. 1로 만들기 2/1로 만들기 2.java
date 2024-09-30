import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        for (int i = 2; i < N+1; i++) {
            dp[i] = dp[i-1] + 1;
            arr[i] = i-1;
            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                arr[i] = i/2;
            }
            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                arr[i] = i/3;
            }
        }

        System.out.println(dp[N]);
        while (N > 0) {
            System.out.print(N + " ");
            N = arr[N];
        }
    }
}