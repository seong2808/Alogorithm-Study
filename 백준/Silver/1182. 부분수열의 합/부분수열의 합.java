import java.io.*;
import java.util.*;

public class Main {
    static int N, S, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        dfs(0, 0, false);

        System.out.println(count);
    }

    private static void dfs(int index, int sum, boolean selected) {
        if (index == N) {
            if (selected && sum == S) {
                count++;
            }
            return;
        }

        dfs(index + 1, sum + arr[index], true);
        dfs(index + 1, sum, selected);
    }
}