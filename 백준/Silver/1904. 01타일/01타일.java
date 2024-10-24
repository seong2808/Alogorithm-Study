import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        arr = new int[N + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }

        System.out.println(arr[N] % 15746);
    }

}
