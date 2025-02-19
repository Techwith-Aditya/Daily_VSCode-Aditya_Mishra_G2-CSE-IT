import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class RightView {
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        rightviewHelp(root, a, 0);
        return a;
    }

    void rightviewHelp(Node root, ArrayList<Integer> a, int level) {
        if (root == null) 
        {
            return;
        }

        if (level == a.size()) 
        {
            a.add(root.data);
        }

        rightviewHelp(root.right, a, level + 1);
        rightviewHelp(root.left, a, level + 1);
    }

    static Node buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
        {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < arr.length)
        {
            Node current = queue.poll();

            // Assign left child
            if (i < arr.length && arr[i] != null)
            {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign right child
            if (i < arr.length && arr[i] != null)
            {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 90, 40, 60};
        Node root = buildTree(arr);

        RightView r = new RightView();
        ArrayList<Integer> a = r.rightView(root);

        System.out.println("Right view of the binary tree: " + a);
    }
}
