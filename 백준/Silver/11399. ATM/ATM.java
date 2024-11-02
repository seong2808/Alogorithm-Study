import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N];


        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i != 0)
                arr[i] = arr[i-1] + arr[i];
            sum += arr[i];
        }
        System.out.println(sum);

    }
}


