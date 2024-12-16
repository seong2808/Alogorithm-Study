import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] nums = new double[N];
        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        char n = 'A';
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            double num1 = 0;
            double num2 = 0;
            switch (c) {
                case '+':
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 + num1);
                    break;
                case '-':
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case '*':
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 * num1);
                    break;
                case '/':
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                case '%':
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 % num1);
                    break;
                default:
                    stack.push(nums[c-n]);
                    break;
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}