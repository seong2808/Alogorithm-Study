import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int s = 0, e = 1, result = 0;
        while (e < N) {
            int sum = arr[s] + arr[e];
            if (sum == M) result++;
            if (e == N-1) {
                s++;
                e = s + 1;
            } else e++;
        }

        System.out.println(result);
    }
}