// solution - 1

// pointer sum with carry --- tc: O(n) sc: O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int rem = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(l1 != null || l2 != null || rem > 0){
            if(l1 != null){
                rem = rem + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                rem = rem + l2.val;
                l2 = l2.next;
            }
                
            int makeNode = rem%10;
            rem = rem/10;
            curr.next = new ListNode(makeNode);

            curr = curr.next;
        }

        return dummy.next;
    }
}
// ------------------------ ( same solution just understanble or reable ) ---------------------------
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int rem = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            rem = rem + l1.val + l2.val;
            int makeNode = rem%10;
            rem = rem/10;
            ListNode newNode = new ListNode(makeNode);
            curr.next = newNode;

            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        while(l1 != null){
            rem = rem + l1.val;
            int makeNode = rem%10;
            rem = rem/10;
            ListNode newNode = new ListNode(makeNode);
            curr.next = newNode;

            l1 = l1.next;
            curr = curr.next;
        }
        while(l2 != null){
            rem = rem + l2.val;
            int makeNode = rem%10;
            rem = rem/10;
            ListNode newNode = new ListNode(makeNode);
            curr.next = newNode;
            
            l2 = l2.next;
            curr = curr.next;
        }
        while(rem > 0){
            int makeNode = rem%10;
            rem = rem/10;
            ListNode newNode = new ListNode(makeNode);
            curr.next = newNode;
            
            curr = curr.next;
        }

        return dummy.next;
    }
}
