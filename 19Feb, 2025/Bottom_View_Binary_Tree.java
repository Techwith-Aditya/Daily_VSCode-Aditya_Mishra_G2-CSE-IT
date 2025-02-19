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
class Pair {
    int line;
    Node node;
    Pair(int line, Node node) {
        this.line=line;
        this.node=node;
    }
}
public class BottomViewOfTree {
    public static ArrayList <Integer> bottomView(Node root) {
        ArrayList<Integer> a=new ArrayList<>();
        TreeMap<Integer, Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        
        if(root==null)
        {
            return a;
        }
        q.add(new Pair(0, root));
        while(!q.isEmpty())
        {
            Pair top=q.remove();
            int line=top.line;
            Node temp=top.node;
            
            // this was in top view approach, that us line ka jo bhi phla mil gya, use put kr do map me:
            // if(map.get(line)==null)
            // {
            //     map.put(line, temp.data);
            // }
            
            // but here in bottom view, us line pe aage jo bhi hme milega vo pichle wale se neeche hoga to that will contribute more to bottom view approach... 
            map.put(line, temp.data);
            
            if(temp.left!=null)
            {
                q.add(new Pair(line-1, temp.left));
            }
            if(temp.right!=null)
            {
                q.add(new Pair(line+1, temp.right));
            }
        }
        for(Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            a.add(pair.getValue());
        }
        return a;
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
        Integer[] arr={1,2,3,4,6};
        Node root=buildTree(arr);
        ArrayList<Integer> a=BottomViewOfTree.bottomView(root);
        System.out.println("Answer list: "+a);
    }
}
