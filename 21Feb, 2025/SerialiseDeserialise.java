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

public class SerialiseDeserialise {
    public static String serialize(TreeNode root) {
        if(root==null)
        {
            return "";
        }
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder s=new StringBuilder();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node==null)
            {
                s.append("n ");
                continue;
            }
            s.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.isEmpty())
        {
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        String[] values=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        
        for(int i=1; i<values.length; i++)
        {
            TreeNode parent=q.poll();
            if(!values[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }

            if(!values[++i].equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
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
        Integer[] a={1,2,3,null,null,4,5};
        TreeNode root=SerialiseDeserialise.buildTree(a);
        String ans=SerialiseDeserialise.serialize(root);
        System.out.println("Answer is: "+ans);
    }
}
