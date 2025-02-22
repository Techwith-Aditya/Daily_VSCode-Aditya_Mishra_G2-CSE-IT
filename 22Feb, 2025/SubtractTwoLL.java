class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SubtractTwoLL {
    static Node subLinkedList(Node head1, Node head2) {
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        if (isSmaller(head1, head2)) 
        {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node result = subtractLists(head1, head2);

        result = reverse(result);
        result = removeLeadingZeros(result);

        return result;
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) 
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isSmaller(Node head1, Node head2) {
        int len1 = getLength(head1), len2 = getLength(head2);
        if (len1 != len2) 
        {
            return len1 < len2;
        }

        while (head1 != null && head2 != null) 
        {
            if (head1.data != head2.data) 
            {
                return head1.data < head2.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return false;
    }

    static int getLength(Node head) {
        int length = 0;
        while (head != null) 
        {
            length++;
            head = head.next;
        }
        return length;
    }

    static Node subtractLists(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        int borrow = 0;

        while (head1 != null) 
        {
            int head2Data = 0;
            if (head2 != null) 
            {
                head2Data = head2.data;
            }

            int diff = head1.data - borrow - head2Data;
            if (diff < 0) 
            {
                diff = diff + 10;
                borrow = 1;
            } 
            else 
            {
                borrow = 0;
            }

            curr.next = new Node(diff);
            curr = curr.next;

            head1 = head1.next;
            if (head2 != null)
            {
                head2 = head2.next;
            }
        }


        return dummy.next;
    }

    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) 
        {
            head = head.next;
        }
        if (head == null) 
        {
            return new Node(0); 
        } 
        return head;
    }

    public static void printList(Node head) {
        while (head != null) 
        {
            System.out.print(head.data);
            if (head.next != null) 
            {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node num1 = new Node(1);
        num1.next = new Node(0);
        num1.next.next = new Node(0);
        num1.next.next.next = new Node(0);

        Node num2 = new Node(9);
        num2.next = new Node(9);

        System.out.print("First Number: ");
        printList(num1);
        System.out.print("Second Number: ");
        printList(num2);

        Node result = subLinkedList(num1, num2);

        System.out.print("Difference: ");
        printList(result);
    }
}
