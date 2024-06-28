import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer tk;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tk = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());

        bw.write(A-B + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
}