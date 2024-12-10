import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            int length = str.length();

            for(int j=0; j<length; j++) {
                char ch = str.charAt(j);

                if(ch == '(') {
                    stack.push(ch);
                }
                else {
                    int size = stack.size();
                    if(size == 0) {
                        stack.push(ch);
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}