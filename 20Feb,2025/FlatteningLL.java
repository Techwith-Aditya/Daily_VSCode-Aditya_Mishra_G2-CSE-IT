class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class FlatteningLL {
    Node flatten(Node head) {
        if (head == null || head.next == null) 
        {
            return head;
        }

        Node mergedHead=flatten(head.next);
        head=mergeTwoLists(head, mergedHead);
        return head;
    }

    Node mergeTwoLists(Node a, Node b) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        // Merge two lists using the bottom pointers
        while (a != null && b != null) 
        {
            if (a.data < b.data) 
            {
                temp.bottom = a;
                temp=a;
                a = a.bottom;
            } 
            else 
            {
                temp.bottom = b;
                temp=b;
                b = b.bottom;
            }
            temp.next = null;
        }
        
        // Attach remaining nodes
        if (a != null) 
        {
            temp.bottom = a;
        } 
        else 
        {
            temp.bottom = b;
        }
        if(dummy.bottom!=null)
        {
            dummy.bottom.next=null;
        }
        return dummy.bottom;
    }

    public void print(Node head) {
        while(head!=null) 
        {
            System.out.print(head.data);
            if(head.bottom!=null)
            {
                System.out.print(" -> ");
            }
            head=head.bottom;
        }
        System.out.println();
    } 

    public static void main(String[] args) {
        FlatteningLL f = new FlatteningLL();

        // Creating a sample linked list
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // Flattening the list
        head = f.flatten(head);

        // Printing the flattened list
        f.print(head);
    }
}
