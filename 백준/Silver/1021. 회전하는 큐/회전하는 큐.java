import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        tk = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(tk.nextToken());
            int idx = deque.indexOf(target);
            int leftMoves = idx;
            int rightMoves = deque.size() - idx;

            if (leftMoves <= rightMoves) {
                for (int j = 0; j < leftMoves; j++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < rightMoves; j++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}