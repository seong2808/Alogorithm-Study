import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }
        System.out.println(max * min);
    }
}