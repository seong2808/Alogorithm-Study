import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
     int idx;
     int height;

    public Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Top> stack = new Stack<>();
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().height >= arr[i]) {
                    System.out.print((stack.peek().idx + 1) + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("0 ");
            }

            stack.push(new Top(i, arr[i]));
        }
    }
}