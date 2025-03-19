import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] order = new int[n];
        boolean[] visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for(int j = 0; j < n; j++){
                if(visited[j])
                    continue;

                if(min > arr[j]){
                    min = arr[j];
                    minIdx = j;
                }
            }

            order[minIdx] = i;
            visited[minIdx] = true;
        }

        for(int i = 0; i < n; i++)
            System.out.print(order[i] + " ");
    }
}