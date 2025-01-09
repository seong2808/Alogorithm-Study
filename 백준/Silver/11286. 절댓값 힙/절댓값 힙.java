import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(queue.isEmpty()) sb.append("0").append("\n");
                else sb.append(queue.poll()).append("\n");
            }else {
                queue.offer(x);
            }
        }
        System.out.println(sb);

    }
}