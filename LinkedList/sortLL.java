//solution - 2

// merge sort --- tc: O(n logn) sc: O(logn)
class Solution {
    
    ListNode merge(ListNode left, ListNode right){

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
            }
            else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left == null ? right : left);
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;
        
        ListNode s = head, f = head, prev = null;

        while(f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(s);

        return merge(left, right);
    }
}

// ------------------------------ ( 2 ) --------------------------------
// Array sorting --- tc: O(n logn) sc: O(n)
class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(arr);

        curr = head;
        for(int i=0; i<arr.size(); i++){
            curr.val = arr.get(i);
            curr = curr.next;
        }
        return head;
    }
}

