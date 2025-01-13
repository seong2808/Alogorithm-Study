import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());
        boolean[] arr = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }

        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                for (int j = i*2; j <= N; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i]) System.out.println(i);
        }
    }
}