import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[][] schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(tk.nextToken());
            schedule[i][1] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(schedule, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        });

        int result = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= schedule[i][0]) {
                end = schedule[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}


