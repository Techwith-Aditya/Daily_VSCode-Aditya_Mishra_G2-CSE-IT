import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val)
    {
        this.val = val;
    }
}

public class MirrorTree {
    public Node invertTree(Node root) {
        if(root==null) 
        {
            return null;
        }

        Node leftSubtree=invertTree(root.left);
        Node rightSubtree=invertTree(root.right);
        
        // swap them...
        root.left=rightSubtree;
        root.right=leftSubtree;

        return root;
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

    public static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.val + " ");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        Node root = buildTree(arr);

        MirrorTree r = new MirrorTree();
        root = r.invertTree(root);

        System.out.println("Mirror tree: ");
        printLevelOrder(root);
    }
}
