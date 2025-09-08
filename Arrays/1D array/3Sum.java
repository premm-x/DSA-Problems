//  ****FAIL****

/*

1. it gives TLE on using 3 for loop logic 
2. sorting it necessary

*/
//----------------------------------------------

//1.  brute --- 3 for loop --- O(n³ * log(ut)) - sc O(ut) --- **TLE**
//2.  optimize --- Hashing (compliment) --- O(n² * log(ut)) - sc O(ut) --- **TLE**

//3.  optimize --- two pointer approch --- O(n² + nlogn)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1, k = n-1;

            while(j < k){
                
                int total = nums[i] + nums[j] + nums[k];

                if(total < 0) j++;
                else if(total > 0) k--;
                else{
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++; k--;
                
                    while(j < k && nums[j] == nums[j-1]) j++;
                }

            }
        }

        return ans;
        
    }
}
