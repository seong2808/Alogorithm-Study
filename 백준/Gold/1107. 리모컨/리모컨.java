import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        int brokenBtnCnt = Integer.parseInt(br.readLine());
        if (brokenBtnCnt != 0) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenBtnCnt; i++) {
                int idx = Integer.parseInt(tk.nextToken());
                broken[idx] = true;
            }
        }

        int result = Math.abs(N - 100);

        for (int i = 0; i < 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                int min = Math.abs(N - i) + num.length();
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }
}