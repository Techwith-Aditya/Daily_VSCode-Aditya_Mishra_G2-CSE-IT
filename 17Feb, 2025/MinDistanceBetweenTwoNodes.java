import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class MinDistanceBetweenTwoNodes {
    static int findDist(Node root, int a, int b) {
        int[] ans=new int[1]; // Use an array to modify ans by reference
        calculate(root, a, b, ans);
        return ans[0];
    }
    
    public static int calculate(Node root, int a, int b, int[] ans) {
        if(root==null) 
        {
            return 0;
        }
        
        int left=calculate(root.left, a, b, ans);
        int right=calculate(root.right, a, b, ans);
        
        if(root.data==a || root.data==b) 
        {
            if(left==0 && right==0) 
            {
                return 1;
            }
            if(left>0) 
            {
                ans[0]=left;
                return left+1;
            }
            if(right>0) 
            {
                ans[0]=right;
                return right+1;
            }
        }
        else
        {
            if(left>0 && right>0) 
            {
                ans[0]=left+right;
                return 0;
            }
            if(left>0) 
            {
                return left+1;
            }
            if(right>0) 
            {
                return right+1;
            }
        }
        return 0;
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

    public static void main(String[] args) {
        Integer[] arr={11, 22, 33, 44, 55, 66, 77};
        Node root=MinDistanceBetweenTwoNodes.buildTree(arr);
        System.out.print("Enter first node: ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.print("Enter second node: ");
        int b=sc.nextInt();
        int ans=MinDistanceBetweenTwoNodes.findDist(root, a, b);
        System.out.println(ans);
        sc.close();
    }
}
