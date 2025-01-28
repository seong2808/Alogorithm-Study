import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int nowX, nowY;
    private static int cnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            tk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tk.nextToken());
            M = Integer.parseInt(tk.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            K = Integer.parseInt(tk.nextToken());
            for (int j = 0; j < K; j++) {
                tk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tk.nextToken());
                int y = Integer.parseInt(tk.nextToken());
                map[x][y] = 1;
            }

            cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        cnt++;
                        dfs(k, j);
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
       visited[y][x] = true;

       for (int i = 0; i < 4; i++) {
           nowX = x + dx[i];
           nowY = y + dy[i];

           if ((nowY < N && nowY >= 0 && nowX < M && nowX >= 0) && !visited[nowY][nowX] && map[nowY][nowX] == 1) {
               dfs(nowX, nowY);
           }
       }
    }
}