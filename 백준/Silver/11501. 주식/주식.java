import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            tk = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            Integer[] nums = new Integer[N];

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
            }

            long result = 0;
            int max = arr[N-1];
            for(int j = N-2; j >= 0; j--) {
                if(arr[j] <= max)
                    result += max - arr[j];
                else
                    max = arr[j];
            }
            System.out.println(result);
        }
        
    }
}


