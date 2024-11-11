import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-2; i >= 0; i--) {
            int score = arr[i+1] - 1;
            
            if (score < arr[i]) {
                ans += arr[i] - score;
                arr[i] = score;
            }
        }

        System.out.println(ans);
    }
}


