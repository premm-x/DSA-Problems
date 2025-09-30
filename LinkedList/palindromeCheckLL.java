//solution - 1
// middle-reverse-check --- O(n)

class Solution {
    
    ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow);

        while(newHead != null){
            if(newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
}
