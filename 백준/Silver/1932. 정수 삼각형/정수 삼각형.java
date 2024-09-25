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

        int N = Integer.parseInt(tk.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                if (i==0) {
                    arr[i][j] = Integer.parseInt(tk.nextToken());
                } else if (i == j) {
                    arr[i][j] = arr[i - 1][j - 1] + Integer.parseInt(tk.nextToken());
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + Integer.parseInt(tk.nextToken());
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + Integer.parseInt(tk.nextToken());
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, arr[N-1][i]);
        }

        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}