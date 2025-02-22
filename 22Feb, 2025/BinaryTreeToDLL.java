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

public class BinaryTreeToDLL {
    static Node head=null;
    static Node prev=null;
    
    static Node bToDLL(Node root) {
        if(root==null)
        {
            return null;
        }
        
        bToDLL(root.left);
        
        if(prev==null)
        {
            head=root;
        }
        
        else
        {
            root.left=prev;
            prev.right=root;
        }
        
        prev=root;
        bToDLL(root.right);
        return head;
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

    static void printDLL(Node head) {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data);
            temp=temp.right;
            if(temp!=null)
            {
                System.out.print("->");
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a={10,20,30,40,60,null,null};
        Node root=BinaryTreeToDLL.buildTree(a);
        Node head=BinaryTreeToDLL.bToDLL(root);
        printDLL(head);
    }
}
