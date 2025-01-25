import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] miro;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                miro[i][j] = Character.getNumericValue(str[j]);
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(miro[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (visited[nextX][nextY] || miro[nextX][nextY] == 0)
                    continue;

                queue.add(new int[] {nextX, nextY});
                miro[nextX][nextY] = miro[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}