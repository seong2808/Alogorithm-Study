import java.io.*;
import java.util.*;

public class Main {
    private static int[][] arr;
    private static int result;
    private static boolean[][] visited;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                search(k - 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    private static void search(int k, int sum) {
        if (k == 0) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                boolean flag=false;
                for (int l = 0; l < 4; l++) {
                    int a = i + dx[l];
                    int b = j + dy[l];
                    if (a >= 0 && a < arr.length && b >= 0 && b < arr[0].length) {
                        if (visited[a][b]) {
                            flag=true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    visited[i][j] = true;
                    search(k - 1, sum + arr[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }
}