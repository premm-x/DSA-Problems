// solution - 1

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
