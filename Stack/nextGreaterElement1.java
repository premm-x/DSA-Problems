// solution - 2

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

// ---------------------------- ( 2 ) -------------------------------
// optimazie ( hashMap + stack) --- tc: O(n) sc: O(n)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<nums2.length; i++){

            while(!st.isEmpty() && nums2[i] > st.peek()){
                map.put(st.pop(), nums2[i]);
            }

            st.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}
