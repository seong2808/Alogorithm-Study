import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split(" ");

            for (int j = 0; j < words.length; j++) {
                words[j] = new StringBuffer(words[j]).reverse().toString();
                sb.append(words[j]);
                sb.append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
 }