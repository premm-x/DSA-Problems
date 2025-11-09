// solution - 1

// deque and hard logic --- tc: O(n) sc: O(n)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = n+1;

        long b[] = new long[n + 1];
        Deque<Integer> d = new ArrayDeque<>();
        
        for(int i=0; i<n; i++)
            b[i + 1] = b[i] + nums[i];

        for(int i=0; i<n + 1; i++){
            
            while(!d.isEmpty() && b[i] - b[d.peekFirst()] >= k)
                ans = Math.min(ans, i - d.pollFirst());
            
            while(!d.isEmpty() && b[i] <= b[d.peekLast()])
                d.pollLast();

            d.offerLast(i);
        }
        return ans <= n ? ans : -1;
    }
}

