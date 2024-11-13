import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int start;
    int end;
    
    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            node[i] = new Node(start, end);
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        Arrays.sort(node,(o1, o2) -> {
            if (o1.start == o2.start)
                return o1.end - o2.end;
            return o1.start - o2.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(node[0].end);
        
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= node[i].start) {
                pq.poll();
            }
            pq.offer(node[i].end);
        }

        System.out.println(pq.size());
    }
}