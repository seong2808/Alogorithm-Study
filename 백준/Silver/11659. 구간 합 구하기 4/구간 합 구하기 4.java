import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());

        int arrLen = Integer.parseInt(tk.nextToken());
        int caseLen = Integer.parseInt(tk.nextToken());

        int[] arr = new int[arrLen+1];

        tk = new StringTokenizer(br.readLine());

        for(int i = 0; i < arrLen+1 ; i++) {
            if (i == 0) {
                arr[0] = 0;
                continue;
            }

            arr[i] = arr[i-1] + Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < caseLen; i++) {
           StringTokenizer tk2 = new StringTokenizer(br.readLine());

           int a = Integer.parseInt(tk2.nextToken());
           int b = Integer.parseInt(tk2.nextToken());

           bw.write(arr[b]- arr[a-1] + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}