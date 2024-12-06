import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());

            switch (tk.nextToken()) {
                case "push" :
                    list.add(Integer.parseInt(tk.nextToken()));
                    break;
                case "pop" :
                    if (list.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(list.get(0)).append("\n");
                        list.remove(0);
                    }
                    break;
                case "size" :
                    sb.append(list.size()).append("\n");
                    break;
                case "empty" :
                    if (list.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    if (list.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(list.get(0)).append("\n");
                    }
                    break;
                case "back" :
                    if (list.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(list.get(list.size() - 1)).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
 }