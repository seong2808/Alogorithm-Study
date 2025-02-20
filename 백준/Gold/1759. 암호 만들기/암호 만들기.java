import java.io.*;
import java.util.*;

public class Main {
    private static char[] arr, result;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(tk.nextToken());
        int c = Integer.parseInt(tk.nextToken());

        result = new char[l];
        arr = new char[c];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = tk.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        search(0, 0, l, c);

        System.out.println(sb);
    }

    private static void search(int index, int depth, int l, int c) {
        if (depth == l) {
            if (!isValid()) return;
            for (char val : result) {
                sb.append(val);
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < c; i++) {
            result[depth] = arr[i];
            search(i+1, depth+1, l, c);
        }
    }

    private static boolean isValid() {
        int m = 0, j = 0;

        for (char val : result) {
            if (val == 'a' || val == 'e' || val == 'i' || val == 'o' || val == 'u') {
                m++;
            } else {
                j++;
            }
        }

        if (m >= 1 && j >= 2) {
            return  true;
        }
        return false;
    }
}