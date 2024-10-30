import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N+1];
        dp = new boolean[N+1][N+1];

        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        tk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tk.nextToken());

        solve(arr, N);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tk.nextToken());
            int e = Integer.parseInt(tk.nextToken());

            if(dp[s][e]) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }
    
    static void solve(int[] arr, int n){
        for(int i = 1; i <= n; i++)
            dp[i][i] = true;

        for(int i = 1; i <= n - 1; i++)
            if(arr[i] == arr[i + 1]) dp[i][i + 1]= true;

        for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
    }







}


