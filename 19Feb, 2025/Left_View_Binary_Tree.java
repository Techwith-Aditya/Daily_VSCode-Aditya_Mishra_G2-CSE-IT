import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    // Constructor for creating a new node
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class LeftView {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewHelper(root, result, 0);
        return result;
    }

    void leftViewHelper(Node root, ArrayList<Integer> result, int level) {
        if (root == null) 
        {
            return;
        }

        if (level == result.size()) 
        {
            result.add(root.data);
        }

        leftViewHelper(root.left, result, level + 1);
        leftViewHelper(root.right, result, level + 1);
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
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = buildTree(arr);

        LeftView sol = new LeftView();
        ArrayList<Integer> leftViewResult = sol.leftView(root);

        System.out.println("Left view of the binary tree: " + leftViewResult);
    }
}
