// solution - 2

// dfs --- tc: O(n) sc: O(n)
class Solution {
    int sum = 0;
    boolean hasPathSum(Node root, int target) {
        if(root == null) return false;
        
        sum += root.data;
        
        if(root.left == null && root.right == null){
            if(sum == target) return true;
        }
        
        if(hasPathSum(root.left, target) || hasPathSum(root.right, target)){
            return true;
        }
        
        sum -= root.data;
        return false;
    }
}

//---------------------------- ( 2 ) -------------------------------
// little bit different fron 1 --- it leetcode 129
// dfs --- tc: O(n) sc: O(n)
class Solution {
    int sum = 0;

    void helper(TreeNode root, int str) {
        if(root == null) return;
        
        str = str * 10 + root.val;

        if(root.left == null && root.right == null){
            sum += str;
        }
        
        helper(root.left, str);
        helper(root.right, str);
    }

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}
