import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int s = arr[0][0];
        int e = arr[0][1];
        int t = e - s;
        for (int i = 1; i < N; i++) {
            if(s <= arr[i][0] && arr[i][1] <= e) {
                continue;
            } else if(arr[i][0] < e) {
                t += arr[i][1] - e;
            } else {
                t += arr[i][1] - arr[i][0];
            }
            s = arr[i][0];
            e = arr[i][1];

        }

        System.out.println(t);
        
    }
}


