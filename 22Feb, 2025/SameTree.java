import java.util.*;
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
    }
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
        {
            return true;
        }
        if (p == null && q != null)
        {
            return false;
        }
        if (p != null && q == null)
        {
            return false;
        }
        if (p.val == q.val)
        {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
        {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < arr.length)
        {
            TreeNode current = queue.poll();

            // Assign left child
            if (i < arr.length && arr[i] != null)
            {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Assign right child
            if (i < arr.length && arr[i] != null)
            {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        SameTree s = new SameTree();
        
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 4};
        
        TreeNode tree1 = buildTree(arr1);
        TreeNode tree2 = buildTree(arr2);
        
        boolean result = s.isSameTree(tree1, tree2);
        
        System.out.println("Are both trees same? Answer is: " + result);
    }
}
