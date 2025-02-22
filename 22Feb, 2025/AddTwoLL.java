class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddTwoLL {
    static Node reverse(Node head) {
        Node prev = null; 
        Node curr = head; 
        Node next = null;
        while (curr != null) 
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Add two numbers represented as linked lists
    static Node add(Node num1, Node num2) {
        int carry = 0;
        Node ansHead = null;
        Node ansTail = null;

        while (num1 != null || num2 != null || carry != 0) 
        {
            int sum = carry;

            if (num1 != null) 
            {
                sum = sum + num1.data;
                num1 = num1.next;
            }

            if (num2 != null) 
            {
                sum = sum + num2.data;
                num2 = num2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;

            Node temp = new Node(digit);
            if (ansHead == null) 
            {
                ansHead = temp; 
                ansTail = temp;
            } 
            else 
            {
                ansTail.next = temp; 
                ansTail = temp;
            }
        }

        return ansHead; 
    }

    static Node addTwoLists(Node num1, Node num2) {
       
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node result = add(num1, num2);

        result = reverse(result);

        // Handle leading zeros (if any)
        while (result != null && result.data == 0) 
        {
            result = result.next;
        }
        
        if(result==null)
        {
            return new Node(0);
        }
        return result;

        // return result == null ? new Node(0) : result; // Return result or single-node 0
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
        Node num1 = new Node(9);
        num1.next = new Node(9);
        num1.next.next = new Node(9);

        Node num2 = new Node(1);

        System.out.print("First Number: ");
        printList(num1);
        System.out.print("Second Number: ");
        printList(num2);

        Node result = addTwoLists(num1, num2);

        System.out.print("Sum: ");
        printList(result);
    }
}
