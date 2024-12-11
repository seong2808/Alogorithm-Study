import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> pipeCnt = new Stack<>();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                pipeCnt.push(ch);
            } else if (ch == ')') {
                if (str.charAt(i-1) == '(') {
                    int pipe = pipeCnt.size() - 1;
                    result += pipe;
                }else {
                    result += 1;
                }
                pipeCnt.pop();
            }
        }

        System.out.println(result);
    }
}