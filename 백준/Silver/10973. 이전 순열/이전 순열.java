import java.io.*;
import java.util.*;
 
public class Main {
static int[] nums;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
 
        tk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tk.nextToken());
        }
        
        if(previousPermutation()) {  
            for(int val : nums) {
                bw.write(val+" ");
            }
        }else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        
    }
    
    public static boolean previousPermutation() {
        int i = nums.length - 1;
        while(i > 0 && nums[i-1] <= nums[i]) {   
            i--;
        }
        if(i < 1) {    
            return false;
        }
        
        int j = nums.length - 1;
        while(nums[i-1] <= nums[j]) {
            j--;
        }
        
        swap(i-1, j);    
        
        j = nums.length-1;
        
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }
    
    public static void swap(int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
 
}