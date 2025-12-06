// solution - 1

// recursive (dfs) --- tc: O(n) sc : O(h)

class Solution {
    
    int depth(Node root){
        int h = 0;
        while(root != null){
            h++;
            root = root.left;
        }
        return h;
    }
    
    boolean isper(Node root, int d, int level){
        if(root == null) return true;
        
        if(root.left == null && root.right == null) return d == level + 1;
        
        if(root.left == null || root.right == null) return false;
        
        return isper(root.left, d, level+1) && isper(root.right, d, level+1);
    }
     
    public boolean isPerfect(Node root) {
        int depth = depth(root);
        return isper(root, depth, 0);
    }
}
