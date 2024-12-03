import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 1;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            result.add("+");
            while (!stack.empty() && stack.peek() == arr[idx]) {
                stack.pop();
                result.add("-");
                idx++;
            }
        }

        if (stack.empty()) {
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
 }




