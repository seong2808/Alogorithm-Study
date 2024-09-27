import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.XMLFormatter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer tk;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());

        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i <  N; i++) {
            tk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(tk.nextToken());

            arr[i] = num;

            if (max < num) max = num;
        }

        int[] dp = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < max+1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(dp[arr[i]] + "\n");
        }



        bw.write("\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
