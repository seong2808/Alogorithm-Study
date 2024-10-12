import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int[] arr = new int[10];
        int max = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '6') {
                arr[9]++;
            } else {
                arr[c-48]++;
            }
        }
        int nine = arr[9] / 2;
        if (arr[9]%2 == 1) {
            nine++;
        }
        for (int i = 0; i < 9; i++) {
            max = Math.max(arr[i], max);
        }
        max = Math.max(max, nine);
        System.out.println(max);
    }
}
