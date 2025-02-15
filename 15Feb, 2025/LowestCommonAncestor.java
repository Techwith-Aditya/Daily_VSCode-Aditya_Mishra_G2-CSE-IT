// Problem: Lowest Common Ancestor of a Binary Tree

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pPath=new ArrayList<>();
        ArrayList<TreeNode> qPath=new ArrayList<>();

        if(!path(root, p.val, pPath) || !path(root, q.val, qPath))
        {
            return null;
        }

        int i;
        for(i=0; i<pPath.size() && i<qPath.size(); i++)
        {
            if(pPath.get(i)!=qPath.get(i))
            {
                break;
            }
        }
        return pPath.get(i-1);
    }

    public static boolean path(TreeNode root, int nodeval, ArrayList<TreeNode> a) {
        if(root==null) 
        {
            return false;
        }
        a.add(root);
        if(root.val==nodeval)
        {
            return true;
        }

        if(path(root.left, nodeval, a) || path(root.right, nodeval, a))
        {
            return true;
        }
        a.remove(a.size()-1);
        return false;
    }

    static TreeNode buildTree(Integer[] arr) {
        if(arr.length==0 || arr[0]==null)
        {
            return null;
        }

        TreeNode root=new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;

        while(i<arr.length)
        {
            TreeNode current=queue.poll();

            // Assign left child
            if(i<arr.length && arr[i]!= null)
            {
                current.left=new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign right child
            if(i<arr.length && arr[i]!=null)
            {
                current.right=new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if(root==null) 
        {
            return null;
        }
        if(root.val==val) 
        {
            return root;
        }
        TreeNode left=findNode(root.left, val);
        if(left!=null) 
        {
            return left;
        }
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        Integer[] arr={3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root=LowestCommonAncestor.buildTree(arr);
        System.out.print("Enter nodes from above: ");
        Scanner sc=new Scanner(System.in);
        int node1=sc.nextInt();
        int node2=sc.nextInt();

        TreeNode p=findNode(root, node1);
        TreeNode q=findNode(root, node2);
        
        if(p==null || q==null) 
        {
            System.out.println("One or both nodes not found in tree.");
        } 
        else 
        {
            TreeNode ans=lowestCommonAncestor(root, p, q);
            if(ans!=null) 
            {
                System.out.println("Lowest Common Ancestor: "+ans.val);
            } 
            else 
            {
                System.out.println("LCA not found.");
            }
        }
        sc.close();
    }
}
