// solution - 3

// hashing --- tc: O(m+n * logn) sc: O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        
        HashSet<ListNode> set = new HashSet<>();

        ListNode l1Temp = l1;
        while(l1Temp != null){
            set.add(l1Temp);
            l1Temp = l1Temp.next;
        }

        ListNode l2Temp = l2;
        while(l2Temp != null){
            if(set.contains(l2Temp)) return l2Temp;
            l2Temp = l2Temp.next;
        }
        return null;
    }
}
// ------------------------ ( 2 ) ------------------------
// lenght basis --- tc: O((m+n) + (m-n) + (n)) ->(m+2n) sc: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        
        ListNode temp1 = l1;
        int count1 = 0;
        while(temp1 != null){
            count1++;
            temp1 = temp1.next;
        }

        ListNode temp2 = l2;
        int count2 = 0;
        while(temp2 != null){
            count2++;
            temp2 = temp2.next;
        }
        
        temp1 = l1;
        temp2 = l2;

        if((count1 - count2) < 0){
            int i = 0;
            while(i < (count2-count1)){
                temp2 = temp2.next;
                i++;
            }
        } 

        if((count1 - count2) > 0){
            int i = 0;
            while(i < (count1-count2)){
                temp1 = temp1.next;
                i++;
            }
        }

        while(temp1 != null){
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}

//----------------------- ( 3 ) ---------------------------
// two pointer --- tc: O(m+n) sc: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null ) return null;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1 != temp2 ){
            
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1;

            if(temp1 == null) temp1 = l2;
            if(temp2 == null) temp2 = l1;

        }
        return temp1;
    }
}
