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
public class PathSum {
    static boolean hasPathSum(Node root, int target) {
        return yesOrNo(root, 0, target);
    }
    
    static boolean yesOrNo(Node node, int currsum, int target) {
        if(node==null)
        {
            return false;
        }
        currsum=currsum+node.data;
        
        if(node.left==null && node.right==null) 
        {
            return currsum==target;
        }
        return yesOrNo(node.left, currsum, target)||yesOrNo(node.right, currsum, target);
    }

    static Node buildTree(Integer[] a) {
        if(a[0]==null && a.length==0)
        {
            return null;
        }
        Node root=new Node(a[0]);
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        int i=1;
        while(i<a.length) 
        {
            Node curr=q.poll();
            if(i<a.length && a[i]!=null)
            {
                curr.left=new Node(a[i]);
                q.add(curr.left);
            }
            i++;

            if(i<a.length && a[i]!=null)
            {
                curr.right=new Node(a[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] a={1,2,3};
        int k=2;
        Node root=PathSum.buildTree(a);
        boolean trueOrfalse=PathSum.hasPathSum(root, k);
        System.out.println(trueOrfalse);
    }
}
