import java.util.*;
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class Duplicate_Subtree {
    static HashMap<String, Integer> subtreeMap = new HashMap<>();
    static boolean hasDuplicate = false;

    static int dupSub(Node root) {
        subtreeMap.clear();
        hasDuplicate = false;
        findDuplicate(root);
        return hasDuplicate ? 1 : 0;
    }

    static String findDuplicate(Node root) {
        if (root == null) 
        {
            return "#";  // Using # to represent null
        }

        String left = findDuplicate(root.left);
        String right = findDuplicate(root.right);

        String subtree = root.data + "," + left + "," + right;

        // Ignore leaf nodes (since a duplicate subtree must have at least size 2)
        if (root.left != null || root.right != null) 
        { 
            subtreeMap.put(subtree, subtreeMap.getOrDefault(subtree, 0) + 1);
            if (subtreeMap.get(subtree) == 2) // Mark duplicate when found twice
            {
                hasDuplicate = true;
            }
        }

        return subtree;
    }

    static Node buildTree(Integer[] arr) {
        if(arr.length == 0 || arr[0] == null) 
        {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while(i < arr.length) 
        {
            Node current = queue.poll();

            // Assign left child
            if(i < arr.length && arr[i] != null) 
            {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
        
    }

    public static void main(String[] args) {
        Integer[] a={1,2,3};
        Node root=Duplicate_Subtree.buildTree(a);
        int ans=Duplicate_Subtree.dupSub(root);
        System.out.print("Answer string is: "+ans);
    }
}
