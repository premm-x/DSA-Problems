//optimal --- two pointer --- O(n³ + nlogn)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int l = i+1; l<n; l++ ){
                
                if(l > i+1 && nums[l] == nums[l-1]) continue;

                int j = l+1, k = n-1;
            
                while(j < k){

                    long total = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(total == target){
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        j++; k--;

                        while(j < k && nums[j] == nums[j-1]) j++;
                    }
                    else if(total > target) k--;
                    else j++;
                }
            }
        }
        
        return ans;
    }
}



