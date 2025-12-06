// solution - 1

// recurvise (dfs) --- tc: O(n) sc: O(h)
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left != null && (root.left.left == null && root.left.right == null)) sum += root.left.val;

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;
    }
}

// ------------------------- same (just sum is now inside function handles) --------------------------
class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        
        if(root.left != null && (root.left.left == null && root.left.right == null)) sum += root.left.val;

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}



