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
public class Binary_Tree_Paths {
    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> a=new ArrayList<>();
        if(root==null) 
        {
            return a;
        }
        findPaths(root, "", a);
        return a;
    }

    private static void findPaths(TreeNode node, String path, List<String> a) {
        if(node==null) 
        {
            return;
        }

        // Add current node to the path
        path=path+node.val;

        // If it's a leaf node, add the whole tracked path till here to list
        if(node.left==null && node.right==null) 
        {
            a.add(path);
            return;
        }

        // If not a leaf, add "->" and recurse on left and right
        path=path+"->";
        findPaths(node.left, path, a);
        findPaths(node.right, path, a);
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

    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5};
        TreeNode root=Binary_Tree_Paths.buildTree(arr);
        List<String> res=new ArrayList<>();
        res=Binary_Tree_Paths.binaryTreePaths(root);
        System.out.println(res);
    }
}
