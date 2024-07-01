import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer tk;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tk = new StringTokenizer(br.readLine());

        // N : N X N
        int N = Integer.parseInt(tk.nextToken());

        // M : 합을 구하는 횟수
        int M = Integer.parseInt(tk.nextToken());

        // 빈 2차원 배열 생성
        int[][] arr = new int[N+1][N+1];

        // 2차원 배열 초기화 및 누적합 2차원 배열 생성
        for (int i = 0; i < N+1; i++) {
            if (i != 0)
                tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N+1; j++) {
                if (i == 0) {
                    arr[i][j] = 0;
                    continue;
                }

                if (j == 0) {
                    arr[i][j] = 0;
                    continue;
                }

                arr[i][j] = Integer.parseInt(tk.nextToken()) + arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1];
            }
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());

            int result = arr[c][d] - arr[c][b-1] - arr[a-1][d] + arr[a-1][b-1];
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}