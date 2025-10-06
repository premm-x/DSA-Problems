// solution - 2

// greate iteration --- tc: O(n + (n-k)) ->(O(2n)) sc: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) return head;
        
        int len = 1;
        ListNode curr = head;
        while(curr.next != null){
            len++;
            curr = curr.next;
        }
        curr.next = head;

        k = k % len;
        int stepToHead = len - k;
        
        for(int i=1; i<stepToHead; i++){
            head = head.next;
        }
        
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}

//---------------------- ( 2 ) ---------------------------
// my logic --- tc: O(n*k) sc: O(1)
class Solution {
    ListNode helper(ListNode head, int k, int i){
        
        if(i >= k) return head;
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        curr.next = head;
        head = curr;

        return helper(head, k, i+1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        return helper(head, k%len, 0);
    }
}
