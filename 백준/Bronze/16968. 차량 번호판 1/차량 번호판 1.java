import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int cnt = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] == 'c') cnt *= 26;
                else cnt *= 10;
            } else {
                if(arr[i]==arr[i-1]){
                    if(arr[i]=='c') cnt *= 25;
                    else cnt *= 9;
                }
                else{
                    if(arr[i] == 'c') cnt *= 26;
                    else cnt *= 10;
                }
            }
        }
        System.out.println(cnt);
    }
}