// solution - 1

// recursive (dfs) --- tc: O(n) sc: O(n) 
class GfG {
    boolean isFullTree(Node node) {
        
        if((node.left == null && node.right == null) || node == null) return true;
        
        if((node.left == null && node.right != null) ||
            (node.right == null && node.left != null)){
            
            return false;
        }
        
        return isFullTree(node.left) && isFullTree(node.right);
    }
}
