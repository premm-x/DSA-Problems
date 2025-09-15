// ------------------------------------- subset 1 ------------------------------------------
// brute --- O(n * ₂n) - sc O(n * ₂n)

class Solution {

    void helper(int[] num, ArrayList<Integer> arr, List<List<Integer>> ans, int i){

        if(i == num.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        arr.add(num[i]);
        helper(num, arr, ans, i+1);

        arr.removeLast();
        helper(num, arr, ans, i+1);

    }

    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, arr, ans, 0);

        return ans;
        
    }
}

// ------------------------------------- subset 2 ------------------------------------------
// brute --- O(n * ₂n) - sc O(n * ₂n)

class Solution {
    
    void helper(int[] nums, ArrayList<Integer> arr, List<List<Integer>> ans, int i){

        if(i == nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[i]);
        helper(nums, arr, ans, i+1);

        arr.removeLast();
        
        while(i+1 < nums.length && nums[i] == nums[i+1]) i += 1;

        helper(nums, arr, ans, i+1);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
        ArrayList<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, arr, ans, 0);

        return ans;

    }
}
