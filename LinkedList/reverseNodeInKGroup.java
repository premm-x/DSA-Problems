// solution - 2

// Brute force --- tc: O(n) sc: O(n/k)(recusion only)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int j = 0;
        while(temp != null && j < k){
            j++;
            temp = temp.next;
        }
        if(j < k) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;
        while(curr != null && i <= k){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}

// ------------------------------ ( 2 ) ----------------------------------
// optimal --- tc: O(n) sc: O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null ) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }

        while(count >= k){
            curr = prev.next;
            ListNode next = curr.next;

            for(int i=1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count = count - k;
        }
        return dummy.next;
    }
}

