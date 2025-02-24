import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0;
        int M = Integer.parseInt(br.readLine());
        StringTokenizer tk;
        while (M-- > 0) {
            tk = new StringTokenizer(br.readLine());
            String str = tk.nextToken();
            if(str.equals("all")) S = (1 << 21) - 1;
            else if(str.equals("empty")) S = 0;
            else {
                int num = Integer.parseInt(tk.nextToken());
                if(str.equals("add"))
                    S |= (1 << num);
                else if(str.equals("remove"))
                    S &= ~(1 << num);
                else if(str.equals("check"))
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if(str.equals("toggle"))
                    S ^= (1 << num);
            }
        }
        System.out.println(sb);
    }
}