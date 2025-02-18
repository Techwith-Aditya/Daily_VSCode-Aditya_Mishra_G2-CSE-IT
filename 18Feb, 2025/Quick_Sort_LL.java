class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QuickSortLL {
    public Node quickSort(Node node) {
        if (node == null || node.next == null) 
        {
            return node;
        }

        Node last = node;
        while (last.next != null) 
        {
            last = last.next;
        }
        int pivot = last.data;

        Node smallerHead = new Node(-1); 
        Node smaller = smallerHead;
        
        Node equalHead = new Node(-1); 
        Node equal = equalHead;
        
        Node largerHead = new Node(-1);
        Node larger = largerHead;
        
        Node temp = node;
        while (temp != null) 
        {
            if (temp.data < pivot) 
            {
                smaller.next = temp;
                smaller = smaller.next;
            } 
            else if (temp.data == pivot) 
            {
                equal.next = temp;
                equal = equal.next;
            } 
            else 
            {
                larger.next = temp;
                larger = larger.next;
            }
            
            temp = temp.next;
        }

        smaller.next = null;
        equal.next = null;
        larger.next = null;

        Node sortedSmaller = quickSort(smallerHead.next);
        Node sortedLarger = quickSort(largerHead.next);

        return concatenate(sortedSmaller, equalHead.next, sortedLarger);
    }

    private static Node concatenate(Node smaller, Node equal, Node larger) {
        Node head = smaller;

        if (smaller != null) 
        {
            while (smaller.next != null) 
            {
                smaller = smaller.next;
            }
            smaller.next = equal;
        } 
        
        else 
        {
            head = equal;
        }

        while (equal.next != null) 
        {
            equal = equal.next;
        }
        equal.next = larger;

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test QuickSortLL
    public static void main(String[] args) {
        QuickSortLL quickSortLL = new QuickSortLL();

        // Create an unsorted linked list
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(7);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        // Sort the linked list
        Node sortedHead = quickSortLL.quickSort(head);

        System.out.println("Sorted List:");
        printList(sortedHead);
    }
}
