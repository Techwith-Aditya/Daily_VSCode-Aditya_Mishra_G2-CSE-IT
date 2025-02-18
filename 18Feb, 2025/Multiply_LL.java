class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next=null;
    }
}

public class MultiplyLL {
    private final long MOD = 1000000007; // jb multiple krke bhut bda number aa jayega, tb MOD apply krke hm remainder return kr dege...chhote numbers me to vhi answer hoga

    public long multiplyTwoLists(Node first, Node second) {
        long num1 = 0;
        long num2 = 0;

        // Convert first LL into number...
        while (first != null) 
        {
            num1 = (num1 * 10 + first.data) % MOD;
            first = first.next;
        }

        // Convert second LL into number...
        while (second != null) 
        {
            num2 = (num2 * 10 + second.data) % MOD;
            second = second.next;
        }

        return (num1 * num2) % MOD; 
    }

    public static void main(String[] args) {
        MultiplyLL m=new MultiplyLL();
        Node head1=new Node(9);
        head1.next=new Node(2);

        Node head2=new Node(3);
        long ans=m.multiplyTwoLists(head1, head2);
        System.out.println("Answer is: "+ans);
    }
}
