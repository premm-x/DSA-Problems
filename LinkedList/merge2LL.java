// solution - 2

// iterative (with dummy) --- O(n)

class Solution {

    ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1; 

        ListNode dum = new ListNode(-1);
        ListNode first = dum;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dum.next = l1;
                l1 = l1.next;
            }
            else{
                dum.next = l2;
                l2 = l2.next;
            }
            dum = dum.next;
        }

        if(l1 != null) dum.next = l1;
        if(l2 != null) dum.next = l2;

        return first.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }
}
//--------------------- 2 -------------------------------
// recursive --- O(n)

class Solution {

    ListNode merge(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null){
            return (l1 == null ? l2 : l1);
        }

       if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
       }else{
            l2.next = merge(l1, l2.next);
            return l2;
       }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }
}


