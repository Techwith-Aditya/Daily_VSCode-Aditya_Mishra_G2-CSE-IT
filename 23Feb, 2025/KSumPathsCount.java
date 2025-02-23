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

public class KSumPathsCount {
    public static int sumK(Node root, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Base case for handling exact sum K
        return dfs(root, 0, k, prefixSumMap);
    }

    private static int dfs(Node node, int currSum, int target, HashMap<Integer, Integer> h) {
        if(node == null) 
        {
            return 0;
        }
        
        currSum=currSum+node.data;
        
        int count=h.getOrDefault(currSum-target, 0);
        h.put(currSum, h.getOrDefault(currSum, 0)+1);
        count=count + dfs(node.left, currSum, target, h);
        count=count + dfs(node.right, currSum, target, h);

        // remove the current sum before returning
        h.put(currSum, h.get(currSum)-1);

        return count;
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
        Integer[] a={8,4,5,3,2,null,2,3,-2,null,1,null,null};
        Node root=KSumPathsCount.buildTree(a);
        int k=7;
        int ans=KSumPathsCount.sumK(root, k);
        System.out.println(ans);
    }
}
