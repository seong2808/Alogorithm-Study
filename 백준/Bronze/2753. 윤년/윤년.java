import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(tk.nextToken());

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println("1");
        else
            System.out.println("0");

    }
}