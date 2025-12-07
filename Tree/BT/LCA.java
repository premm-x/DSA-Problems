// solution - 2

// dfs path common approch --- tc: O(n) sc: O(n)
class Solution {
    
    boolean dfs(TreeNode root, TreeNode trg, Deque<TreeNode> q){
        if(root == null) return false;

        q.add(root);
        if(root.val == trg.val) return true;

        if(dfs(root.left, trg, q)) return true;
        if(dfs(root.right, trg, q)) return true;
        
        q.pollLast();

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Deque<TreeNode> q1 = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();

        dfs(root, p, q1);
        dfs(root, q, q2);

        TreeNode ans = null;
        while(!q1.isEmpty() && !q2.isEmpty() && q1.peekFirst().val == q2.peekFirst().val){
            ans = q1.pollFirst();
            q2.pollFirst();
        }
        
        return ans;
    }
}

//----------------------------------------- ( 2 ) ---------------------------------------------
// more simple to read (dfs) --- tc: O(n) sc: O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}
