import java.io.*;

public class Main {
    static long MOD = 1000000;
    static long pisano = 1500000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        n %= pisano;
        long[] fibo = new long[(int) n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0)
                fibo[i] = 0;
            else if (i == 1)
                fibo[i] = 1;
            else
                fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }

        System.out.println(fibo[(int) n] % MOD);
    }

 }