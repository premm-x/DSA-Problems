// solution - 1

// dfs -- bend path handel then straight path pass to parent --- tc: O(n) sc: O(h)
class Solution {
    int maxSum = Integer.MIN_VALUE;

    int helper(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int currSum = root.val + left + right;

        maxSum = Math.max(maxSum, currSum);
        
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
}
