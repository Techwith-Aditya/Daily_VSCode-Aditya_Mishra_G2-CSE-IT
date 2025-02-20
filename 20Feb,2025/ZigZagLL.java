class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ZigZagLL {
    Node zigZag(Node head) {
        Node curr=head;
        int i=0;
        
        while(curr.next!=null)
        {
            if(i%2==0)
            {
                if(curr.data>=curr.next.data)
                {
                    swap(curr);
                }
                i++;
            }
            else
            {
                if(curr.data<=curr.next.data)
                {
                    swap(curr);
                }
                i++;
            }
            curr=curr.next;
        }
        return head;
    }
    
    void swap(Node node) {
        int temp=node.data;
        node.data=node.next.data;
        node.next.data=temp;
    }

    public void print(Node head) {
        Node temp=head;
        while(temp!=null) 
        {
            System.out.print(temp.data);
            if(temp.next!=null)
            {
                System.out.print(" -> ");
            }
            temp=temp.next;
        }
        // System.out.println();
    } 

    public static void main(String[] args) {
        ZigZagLL z = new ZigZagLL();

        // Creating a sample linked list
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        System.out.print("Original List: ");
        z.print(head);
        System.out.println();

        head = z.zigZag(head);
        System.out.print("Zig-Zag Reordered List: ");
        z.print(head);
    }
}
