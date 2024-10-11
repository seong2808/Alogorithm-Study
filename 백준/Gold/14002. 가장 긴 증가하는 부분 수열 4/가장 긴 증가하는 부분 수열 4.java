import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[][] dp;
    static int[] dpLen;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        arr = new int[N+1];
        dpLen = new int[N+1];
        int maxLen = Integer.MIN_VALUE;


        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }


        for (int i = 0; i < N+1; i++) {
            int[] arr1 = new int[i+1];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpLen[i] = Math.max(dpLen[j] + 1, dpLen[i]);
                }
            }
            maxLen = Math.max(maxLen, dpLen[i]);
        }


        Stack<Integer> stack = new Stack<>();
        int value = maxLen;

        for (int i = N; i > 0; i--) {
            if (value == dpLen[i]) {
                stack.push(arr[i]);
                value--;
            }
        }

        System.out.println(maxLen);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
