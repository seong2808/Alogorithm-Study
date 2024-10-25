import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	public static int N, M, K;
	public static int answer = 0;
	public static int[][] map;
	public static int[][] dp;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = 0;
    	while(true) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		K = Integer.parseInt(st.nextToken());
    		if(K == 0)
    			return ;
    		
    		map = new int[K][3];
    		dp = new int[K][3];
    		for(int i=0;i<K;i++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			int c = Integer.parseInt(st.nextToken());
    			
    			map[i][0] = a;
    			map[i][1] = b;
    			map[i][2] = c;
    			
    		}
    		simulate();
    		T+=1;
    		System.out.println(T+". "+map[K-1][1]);
    	}
    }
    
    public static void simulate() {
    	
    	map[0][2] += map[0][1];
    	
    	map[1][0] += map[0][1];
    	map[1][1] += Math.min(map[1][0], Math.min(map[0][1], map[0][2]));
    	map[1][2] += Math.min(map[0][1], Math.min(map[1][1], map[0][2]));
    	
    	for(int i=2; i<K;i++) {
    		map[i][0] = Math.min(map[i-1][0], map[i-1][1]) + map[i][0];
    		map[i][1] = Math.min(Math.min(map[i][0], map[i-1][0]), Math.min(map[i-1][1], map[i-1][2])) + map[i][1];
    		map[i][2] = Math.min(Math.min(map[i][1], map[i-1][1]), map[i-1][2]) + map[i][2];
    	}
    	
    }
}