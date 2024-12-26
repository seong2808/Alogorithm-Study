import java.io.*;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            char root = tk.nextToken().charAt(0);
            char left = tk.nextToken().charAt(0);
            char right = tk.nextToken().charAt(0);
            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }

    public static void insertNode(Node temp, char root, char left, char right) {
        if (temp.data == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (temp.left != null) {
                insertNode(temp.left, root, left, right);
            }
            if (temp.right != null) {
                insertNode(temp.right, root, left, right);
            }
        }
    }

    public static void preOrder (Node node) {
        if (node == null)
            return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    public static void postOrder (Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
