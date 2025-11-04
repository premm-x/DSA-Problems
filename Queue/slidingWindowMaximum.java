// solution - 1

// Deque approch --- tc: O(n) sc: (k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int ans[] = new int[nums.length - (k-1)];
        Deque<Integer> pq = new ArrayDeque<>();
        int j = 0;

        for(int i=0; i<nums.length; i++){
            while(!pq.isEmpty() && pq.peekFirst() <= i-k) pq.pollFirst();
            while(!pq.isEmpty() && nums[pq.peekLast()] < nums[i]) pq.pollLast();
            
            pq.offerLast(i);
            if(i >= k-1) ans[j++] = nums[pq.peekFirst()];
        }
        return ans;
    }
}
