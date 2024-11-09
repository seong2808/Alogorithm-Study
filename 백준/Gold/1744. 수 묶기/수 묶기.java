import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int result = 0;
        int minusCnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= 0) {
                minusCnt++;
            }
        }

        Arrays.sort(arr);

        for (int i = 1; i < minusCnt; i+=2) {
            result += (arr[i] * arr[i-1]);
        }

        if (minusCnt % 2 == 1)
            result += arr[minusCnt-1];

        if ((N - minusCnt) % 2 == 1) {
            result += arr[minusCnt];
        }

        for (int i = N- 1; i > minusCnt ; i -= 2) {
            int mul = arr[i] * arr[i - 1];
            int sum = arr[i] + arr[i - 1];
            if (mul > sum) {
                result += mul;
            } else {
                result += sum;
            }
        }

        System.out.println(result);
    }
}


