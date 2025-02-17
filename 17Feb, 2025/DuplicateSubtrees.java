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

public class DuplicateSubtrees {
    static HashMap<String, Integer> h=new HashMap<>();
    
    public static List<Node> printAllDups(Node root) {
        List<Node> ans=new ArrayList<>();
        solve(root, ans);
        return ans;
    }
    
    private static String solve(Node root, List<Node> res) {
        if(root==null) 
        {
            return "#";
        }

        StringBuilder sb=new StringBuilder();
        sb.append(solve(root.left, res)).append(",");
        sb.append(solve(root.right, res)).append(",");
        sb.append(root.data);

        String s=sb.toString();

        if(h.containsKey(s))
        { 
            h.put(s, h.get(s) + 1);
        }
        else
        { 
            h.put(s, 1);
        }

        if(h.get(s)==2) 
        {
            res.add(root);
        }
        return s;
    }

    static Node buildTree(Integer[] arr) {
        if(arr.length==0 || arr[0]==null)
        {
            return null;
        }

        Node root=new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i=1;

        while(i<arr.length)
        {
            Node current=queue.poll();

            // Assign left child
            if(i<arr.length && arr[i]!= null)
            {
                current.left=new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign right child
            if(i<arr.length && arr[i]!=null)
            {
                current.right=new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printPreorder (Node root) {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,null,2,4,null,null,4};
        Node root=DuplicateSubtrees.buildTree(arr);
        List<Node> l=new ArrayList<>();
        l=printAllDups(root);
        for(Node node:l)
        {
            printPreorder(node);
            System.out.println();
        }
    }
}
