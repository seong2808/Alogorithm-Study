import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(tk.nextToken());
        int s = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        
        int E = 0;
        int S = 0;
        int M = 0;
        int year = 0;
        
        while (true) {
            year++;
            E++;
            S++;
            M++;
            
            if (E == 16) E = 1;
            if (S == 29) S = 1;
            if (M == 20) M = 1;
            if (e == E && S == s && M == m) break;
        }

        System.out.println(year);
    }
}