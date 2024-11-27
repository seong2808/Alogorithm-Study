import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while (true) {
            if (palindrome(num) && primeNumber(num)) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }

    public static boolean palindrome(int num) {
        String str = Integer.toString(num);
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() -i -1))
                return false;
        }
        return true;
    }

    public static boolean primeNumber(int num) {
        if(num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
 }




