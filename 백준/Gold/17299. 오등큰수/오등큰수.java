import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] seqCnt = new int[1_000_001];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        tk = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            seq[i] = Integer.parseInt(tk.nextToken());
            seqCnt[seq[i]]++;
        }

        for(int i = 0; i<N; i++){
            while(!stack.isEmpty() && seqCnt[seq[stack.peek()]]<seqCnt[seq[i]]){
                result[stack.pop()] = seq[i];
            }

            stack.add(i);
        }

        while(!stack.isEmpty())
            result[stack.pop()] = -1;

        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        } 

        System.out.println(sb);
    }
}