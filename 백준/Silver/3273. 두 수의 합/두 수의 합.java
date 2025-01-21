import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(seq);

        int x = Integer.parseInt(br.readLine());
        int e = 0, result = 0;
        boolean isOver = false;
        for (int i = 0; i < n; i++) {
            isOver = false;
            e = i + 1;
            while (e != n) {
                int sum = seq[i] + seq[e];
                if (sum == x) result++;
                if (sum > x) {
                    isOver = true;
                    break;
                }
                e++;
            }
            if (isOver) continue;
        }

        System.out.println(result);
    }
}