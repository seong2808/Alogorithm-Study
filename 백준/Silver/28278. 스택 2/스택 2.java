import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "1":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "2":
                    if (stack.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case "3":
                    sb.append(stack.size()).append("\n");
                    break;
                case "4":
                    sb.append(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case "5":
                    if (stack.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}