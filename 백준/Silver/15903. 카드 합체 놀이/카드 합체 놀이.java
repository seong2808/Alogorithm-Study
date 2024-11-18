import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        long[] arr = new long[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            arr[0] += arr[1];
            arr[1] = arr[0];
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}


