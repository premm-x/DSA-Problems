// solution - 3

/* 3 ways 
- 1. with sum outside function
- 2. with sum inside function
- 3. without sum (remaing value formula (trg - root.val) )

*/

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

// ------------------------------ ( 3 ) -----------------------------------
// dfs (same just) (without sum) --- tc: O(n) sc: O(n) 
class Solution {
    public boolean hasPathSum(TreeNode root, int trg) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == trg;
        return hasPathSum(root.left, trg - root.val) || hasPathSum(root.right, trg - root.val);
    }
}







