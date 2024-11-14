import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int[] test = new int[N];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            test[i] = Integer.parseInt(tk.nextToken());
        }

        tk = new StringTokenizer(br.readLine());
        int general = Integer.parseInt(tk.nextToken());
        int deputy = Integer.parseInt(tk.nextToken());

        long ans = 0;
        for (int i = 0; i < N; i++) {
            double tester = test[i];

            tester -= general;
            ans++;

            if (tester <= 0)
                continue;

            ans += (int) Math.ceil(tester / deputy);
        }

        System.out.println(ans);
    }
}


