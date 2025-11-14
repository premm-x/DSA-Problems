// solution - 2

// ( 1. brute tc: O(n²) ,  2. optimal tc: O(n) )

// brute force --- tc: O(n²) sc: O(1)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            int max = nums[i];
            for(int j=i; j<nums.length; j++){

                max = Math.max(max, nums[j]);

                if(max >= left && max <= right) {
                    ans++;
                }

            }
        }
        return ans;
    }
}

//------------------------------------- ( 2 ) ----------------------------------------
// optimal using high & low --- tc: O(n) sc: O(1)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int high = 0, low = 0, ans = 0;

        for(int i=0; i<nums.length; i++){

            if(nums[i] > right) high = 0;
            else ans += ++high;

            if(nums[i] >= left) low = 0;
            else ans -= ++low;

        }
        return ans;
    }
}
