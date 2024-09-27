import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer tk;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args)throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tk = new StringTokenizer(br.readLine());

        // 계단 갯수
        int num = Integer.parseInt(tk.nextToken());

        dp = new Integer[num+1];
        arr = new int[num+1];

        for (int i = 1; i < num+1; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (num >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        bw.write(recur(num) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static int recur(int num) {
        if (dp[num] == null) {
            dp[num] = Math.max(recur(num-2), recur(num-3) + arr[num-1]) + arr[num];
        }

        return dp[num];
    }

}
