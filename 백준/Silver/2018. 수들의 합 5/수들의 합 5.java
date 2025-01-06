import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int s = 1;
        int e = 1;
        int sum = 0;
        while (s <= N) {
            sum += e;
            if (sum == N) result++;
            if (e == N || sum >= N) {
                s++;
                e = s;
                sum = 0;
            } else e++;
        }
        System.out.println(result);
    }
}