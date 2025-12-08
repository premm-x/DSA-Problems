// solution - 2

// 2 way - with or without sum

// dfs (with sum) --- tc: O(n) sc: O(n)
class Solution {

    void helper(TreeNode root, int trg, int sum, ArrayList<Integer> arr, List<List<Integer>> ans) {
        if(root == null) return;

        arr.add(root.val);
        sum += root.val;

        if(root.left == null && root.right == null && sum == trg){
            ans.add(new ArrayList<>(arr));
        }

        helper(root.left, trg, sum, arr, ans);
        helper(root.right, trg, sum, arr, ans);

        arr.removeLast();
    }


    public List<List<Integer>> pathSum(TreeNode root, int trg) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        helper(root, trg, 0, arr, ans);

        return ans;
    }
}

//------------------------------- ( 2 ) ------------------------------------
// dfs (without sum, using remaining) --- tc: O(n) sc: O(n)
class Solution {

    void helper(TreeNode root, int trg, ArrayList<Integer> arr, List<List<Integer>> ans) {
        if(root == null) return;

        arr.add(root.val);

        if(root.left == null && root.right == null && root.val == trg){
            ans.add(new ArrayList<>(arr));
        }

        helper(root.left, trg - root.val, arr, ans);
        helper(root.right, trg - root.val, arr, ans);

        arr.removeLast();
    }


    public List<List<Integer>> pathSum(TreeNode root, int trg) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        helper(root, trg, arr, ans);

        return ans;
    }
}
