import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
            }

            long gcdSum = 0;
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    gcdSum += gcd(arr[j], arr[k]);
                }
            }
            sb.append(gcdSum + "\n");
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
