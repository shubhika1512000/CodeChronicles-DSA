public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int carry = 0;

        while(l2 != null) {
            
            int val = l1.val + l2.val + carry;    
            carry   = val/10;
            l1.val  = val%10; 

            if(l2.next != null) {
                if(l1.next == null) l1.next = new ListNode(0);
            }    
            else {
                if(l1.next == null && carry > 0 ) l1.next = new ListNode(0);
            }

            l2 = l2.next;
            l1 = l1.next;  
        }

        if(carry > 0) {
            while(l1 != null) {
                int val = l1.val + carry;    
                carry   = val/10;
                l1.val  = val%10;  

                if(l1.next == null && carry > 0) l1.next = new ListNode(0);
                l1 = l1.next; 
            }
        }

        return head;
    }

    //   Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

/**
    9 9 9 9 9 9 9
          9 9 9 9
  1 0 0 0 9 9 9 8
 */