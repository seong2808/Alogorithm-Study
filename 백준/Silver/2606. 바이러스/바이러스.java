import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;  
    static boolean[] visited;   
    static int N, M;        
    static int count;       

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];  
        visited = new boolean[N + 1];

        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;     
            graph[y][x] = true;
        }

        dfs(1);         

        System.out.println(count - 1);
    }

    static void dfs(int idx) {
        visited[idx] = true; 
        count++;       

        for (int i = 1; i <= N; i++) {   
            if (visited[i] == false && graph[idx][i]) {     
                dfs(i);   
            }
        }
    }
}