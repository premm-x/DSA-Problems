// solution - 1

// brute force --- tc: O(n²) sc: O(nums1)
// to optimize the sc use nums1 rather ans array

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        boolean open = false;
        
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){

                if(nums1[i] == nums2[j]){
                    open = true;
                }
                if(open){
                    if(j == nums2.length-1 || nums1[i] > nums2[j+1] ) ans[i] = -1;
                    else{
                        ans[i] = nums2[j+1];
                        break;
                    }
                }
            }
            open = false;
        }
        return ans;
    }
}
