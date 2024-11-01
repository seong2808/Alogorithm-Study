import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[][] arr = new int[2][N];


        for (int i = 0; i < 2; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[0][i] * arr[1][N-1-i];
        }
        System.out.println(sum);

    }
}


