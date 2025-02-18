class ListNode {
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
        {
            return;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode secondHead=slow.next;
        slow.next=null;

        ListNode curr=secondHead;
        ListNode prev=null;
        ListNode nex=curr.next;
        while(curr!=null)
        {
            nex=curr.next;   
            curr.next=prev;
            prev=curr;
            curr=nex;
        }

        ListNode t1=head;
        ListNode t2=prev;
        while(t2!=null)
        {
            ListNode m1=t1.next;
            ListNode m2=t2.next;
            t1.next=t2;
            t2.next=m1;
            t1=m1;
            t2=m2;
        }
        // return head; ---> can't use because function is void 
    }

    public void print(ListNode head) {
        while(head!=null) 
        {
            System.out.print(head.data);
            if(head.next!=null)
            {
                System.out.print(" -> ");
            }
            head=head.next;
        }
        // System.out.println();
    } 

    public static void main(String[] args) {
        ReorderList r=new ReorderList();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        
        r.reorderList(head);
        r.print(head);
    }
}
