// O(n²)

class Solution {

    HashSet<ArrayList<Integer>> set = new HashSet<>();

    void helper(int[] arr, ArrayList<Integer> com, List<List<Integer>> ans, int trg, int i){

        if(i >= arr.length || trg < 0) return;

        if(trg == 0){
            if(!set.contains(com)){
                ans.add(new ArrayList<>(com));
                set.add(com);
            }
            
            return;
        }

        com.add(arr[i]);
        helper(arr, com, ans, trg - arr[i], i+1);
        helper(arr, com, ans, trg - arr[i], i);

        com.removeLast();
        helper(arr, com, ans, trg, i+1);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> com = new ArrayList<>();

        helper(arr, com, ans, target, 0);
        
        return ans;
    }
}
