// solution -1

// sliding Window max approch used i here --- tc: O(n) sc: O(k)
class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();
            
            if(arr[i] < 0) dq.offerLast(i);
            
            if(i >= k-1){
               if(dq.isEmpty()) ans.add(0);
               else ans.add(arr[dq.peekFirst()]);
            }
        }
        return ans;
    }
}
