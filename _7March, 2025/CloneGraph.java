import java.util.*;
class Node{
    int val;
    ArrayList<Node> adj;
    Node(int val) {
        this.val=val;
        this.adj=new ArrayList<>();
    }
}

public class CloneGraph {
    public static Node cloneGraph(Node node) {
        if(node==null)
        {
            return null;
        }
        HashMap<Node, Node> h=new HashMap<>();
        Node ans=cloneHelp(node, h);
        return ans;
    }

    public static Node cloneHelp(Node node, HashMap<Node, Node> h) {
        Node root=new Node(node.val);
        h.put(node, root);
        for(Node neighbour:node.adj)
        {
            if(!h.containsKey(neighbour))
            {
                root.adj.add(cloneHelp(neighbour, h));
            }
            else
            {
                root.adj.add(h.get(neighbour));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        // for(int i=0; i<=4; i++)
        // {
        //     adj.add(new ArrayList<>());
        // }
        // adj.get(1).add(2);
        // adj.get(2).add(1);

        // adj.get(1).add(4);
        // adj.get(4).add(1);

        // adj.get(2).add(3);
        // adj.get(3).add(2);

        // adj.get(3).add(4);
        // adj.get(4).add(3);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);

        node1.adj.add(node2);
        node2.adj.add(node1);

        node1.adj.add(node4);
        node4.adj.add(node1);

        node2.adj.add(node3);
        node3.adj.add(node2);

        node3.adj.add(node4);
        node4.adj.add(node3);

        Node ansRoot=cloneGraph(node3);
        System.out.println("Original Node: " + node3.val);
        System.out.println("Cloned Node: " + ansRoot.val);
    }
}
