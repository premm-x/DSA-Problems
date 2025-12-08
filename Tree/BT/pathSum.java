// solution - 1

// dfs (sum handel outside function) --- tc: O(n) sc: O(n) 
class Solution {
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int trg) {
        if(root == null) return false;

        sum += root.val;

        if(root.left == null && root.right == null && sum == trg) return true;

        if(hasPathSum(root.left, trg) || hasPathSum(root.right, trg)) return true;

        sum -= root.val;

        return false;
    }
}

// ------------------------------ ( 2 ) -----------------------------------
// dfs (same just) (sum handel inside function) --- tc: O(n) sc: O(n) 
class Solution {
    
    public boolean helper(TreeNode root, int trg, int sum) {
        if(root == null) return false;

        sum += root.val;

        if(root.left == null && root.right == null && sum == trg) return true;

        if(helper(root.left, trg, sum) || helper(root.right, trg, sum)) return true;

        return false;
    }

    public boolean hasPathSum(TreeNode root, int trg) {
        return helper(root, trg, 0);
    }
}








