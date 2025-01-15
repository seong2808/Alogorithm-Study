import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        arr = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());

            int calc = Integer.parseInt(tk.nextToken());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            if (calc == 0) {
                union(a, b);
            } else {
                boolean result = check(a, b);
                if (result) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) arr[b] = a;
    }

    private static int find(int a) {
        if (a == arr[a]) return a;
        else {
            return arr[a] = find(arr[a]);
        }
    }

    private static boolean check(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        else return false;
    }
}