import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split("");

        Stack<String> leftStack = new Stack<String>();
        for(int i=0;i<str.length;i++) {
            leftStack.push(str[i]);
        }

        Stack<String> rightStack = new Stack<String>();

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String command[] = br.readLine().split(" ");

            if(command[0].equals("P")) {
                leftStack.push(command[1]);
            }else if(command[0].equals("L")) {
                if(leftStack.size()>0) {
                    rightStack.push(leftStack.pop());
                }
            }
            else if(command[0].equals("D")) {
                if(rightStack.size()>0) {
                    leftStack.push(rightStack.pop());
                }
            }
            else if(command[0].equals("B")) {
                if(leftStack.size()>0) {
                    leftStack.pop();
                }
            }
        }
        
        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();

        }
 }



