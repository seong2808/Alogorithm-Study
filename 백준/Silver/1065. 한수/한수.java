import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                count++;
            } else {
                int hundreds = i / 100;
                int tens = (i / 10) % 10;
                int ones = i % 10;
                if ((hundreds - tens) == (tens - ones)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}