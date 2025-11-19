// solution - 2

// inorder approch  --- 
class Solution {
    Integer prev = null;
    
    boolean check(TreeNode root){
        if(root == null) return true;

        if(!check(root.left)) return false;

        if(prev != null && root.val <= prev) return false;
        prev = root.val;

        return check(root.right);        
    }

    public boolean isValidBST(TreeNode root) {
        return check(root);
    }
}

// ---------------------------- ( 2 ) -------------------------------
// min & max constrain approch --- 
class Solution {
    
    boolean check(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;

        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

