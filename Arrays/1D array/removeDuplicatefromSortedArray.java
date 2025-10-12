// solution - 1

// used sorted advantage --- tc: O(n) sc: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[n] < nums[i]){
                nums[n+1] = nums[i];
                n++;
            }
        }
        return n+1;
    }
}
