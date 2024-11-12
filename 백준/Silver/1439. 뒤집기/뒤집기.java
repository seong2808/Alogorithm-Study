import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();
        int change = 0;

        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i-1] != charArr[i])
                change++;
        }

        System.out.println((change + 1)/2);
    }
}


