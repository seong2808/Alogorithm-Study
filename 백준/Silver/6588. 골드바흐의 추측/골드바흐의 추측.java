import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];

        for (int i = 0; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= MAX; i++) {
            for (int j = i*2; j <= MAX; j+=i) {
                if (!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                break;

            boolean result = false;
            for (int i = 2; i <= num/2; i++) {
                if (isPrime[i] && isPrime[num-i]) {
                    sb.append(num + " = " + i + " + " + (num-i) + "\n");
                    result = true;
                    break;
                }
            }
            if (!result)
                sb.append("Goldbach's conjecture is wrong.\n");
        }

        System.out.println(sb);
    }
}
