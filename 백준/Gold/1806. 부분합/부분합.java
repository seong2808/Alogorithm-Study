import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        // 배열의 길이
        int N = Integer.parseInt(tk.nextToken());
        // 목표 값
        int SUM = Integer.parseInt(tk.nextToken());
        // 목표 값의 최소 길이
        int minLen = Integer.MAX_VALUE;

        // 배열
        int[] arr = new int[N+1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int s = 0;
        int e = 0;
        int total = 0;
        while (s <= N && e <= N) {
            if (total >= SUM && minLen > e - s) minLen = e - s;
            if (total < SUM) total += arr[e++];
            else total -= arr[s++];
        }

        if (minLen == Integer.MAX_VALUE) bw.write("0");
        else bw.write(minLen + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
