import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int[] dp = new int[N+1];

        dp[0] = 1;
        for(int i=2; i<=N; i+=2){
            dp[i] = dp[i-2]*3;
            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j]*2;
            }
        }

        System.out.println(dp[N]);
    }
}


