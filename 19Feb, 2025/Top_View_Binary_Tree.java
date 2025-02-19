import java.util.*;
class Pair {
    Node node;
    int line;
    Pair(int line, Node node) {
        this.line=line;
        this.node=node;
    }
}

class Node {
    Node left;
    Node right;
    int data;
    Node(int data) {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class TopViewOfTree {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> a=new ArrayList<>();
        if(root==null)
        {
            return a;
        }
        TreeMap<Integer, Integer> map=new TreeMap<>(); // stores (line no, Node's value)...root ki line 0 and usse left -1 fir -2...aur root k right me +1, fir +2...
        Queue<Pair> q=new LinkedList<>(); // stores (line no, node (not data))...
        
        q.add(new Pair(0, root));
        while(!q.isEmpty())
        {
            // get topmost node and it's line no...
            Pair top=q.remove(); // hold top pair (_,_)...
            int line=top.line;
            Node temp=top.node;
            
            if(map.get(line)==null)
            {
                map.put(line, temp.data);
            }
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
        // TopViewOfTree sol=new TopViewOfTree();
        // Integer[] arr = {10, 20, 30, 40, 60, 90, 100};
        // Node root=buildTree(arr);
        // ArrayList<Integer> a=sol.topView(root);
        // System.out.println(a);

        // The error occurs because topView(Node root) is a static method, meaning it belongs to the class, not an instance (object). 
        // So, you can't call it using an object (like sol.topView(root)). So, no need to declare the objects...
        // _____________________________________________________________________________________________________________________________

        Integer[] arr={10, 20, 30, 40, 60, 90, 100};
        Node root=buildTree(arr);
        // System.out.println("Built Tree using input: "+root); // it will give some random address of root node...
        ArrayList<Integer> a=TopViewOfTree.topView(root);
        System.out.println("Answer list: "+a);
    }
}
