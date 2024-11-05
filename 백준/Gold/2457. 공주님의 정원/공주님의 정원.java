import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken()) * 100 + Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken()) * 100 + Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        int endDay = 1201;
        int start = 301;
        int result = 0;
        int max = 0;
        int index = 0;

        
        while(start < endDay) {
            boolean isFinded = false;

            for(int i = index; i < N; i++) {
                if(arr[i][0] > start) {	
                    break;
                }

                if(max < arr[i][1]) {
                    isFinded = true;
                    max = arr[i][1];
                    index = i + 1;
                }
            }

            if(isFinded) {
                start = max;
                result++;
            }
            else {
                break;
            }
        }
        System.out.println(max < endDay ? 0 : result);
    }
}


