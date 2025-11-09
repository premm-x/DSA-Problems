// solution - 1

// simple logical approch --- tc: O(n) sc: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, ans = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                ans = Math.min(ans, i - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
