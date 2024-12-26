import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] arr;
    static int N;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    swap(i, j, i, j + 1);
                    candyCheck(i, j);
                    candyCheck(i, j + 1);
                    swap(i, j, i, j + 1);
                }
                
                if (i < N - 1) {
                    swap(i, j, i + 1, j);
                    candyCheck(i, j);
                    candyCheck(i + 1, j);
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);

    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static void candyCheck(int r, int c) {
        int[] row = new int[N];
        int[] column = new int[N];
        Arrays.fill(row, 1);
        Arrays.fill(column, 1);

        // 세로로 긴 수열 확인
        for (int i = 1; i < N; i++) {
            if (arr[r][i-1] == arr[r][i])
                row[i] = row[i-1] + 1;
            max = Math.max(row[i], max);
        }

        // 가로로 긴 수열 확인
        for (int i = 1; i < N; i++) {
            if (arr[i-1][c] == arr[i][c])
                column[i] = column[i-1] + 1;
            max = Math.max(column[i], max);
        }
    }
}
