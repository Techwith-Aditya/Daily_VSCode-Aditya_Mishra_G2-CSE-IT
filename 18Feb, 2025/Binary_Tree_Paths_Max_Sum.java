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

public class BinaryTreeMaxPathSum {
    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(Node root) {
        maxPath(root);
        return maxSum;
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

    private static int maxPath(Node node) {
        if(node==null) 
        {
            return 0;
        }

        int leftSum=Math.max(0, maxPath(node.left));
        int rightSum=Math.max(0, maxPath(node.right));

        maxSum=Math.max(maxSum, leftSum+rightSum+node.data);
        
        return node.data+Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Integer[] arr={-10,9,20,null,null,15,7};
        Node root=BinaryTreeMaxPathSum.buildTree(arr);
        int ans=BinaryTreeMaxPathSum.maxPathSum(root);
        System.out.print("Answer is: "+ans);
    }
}
