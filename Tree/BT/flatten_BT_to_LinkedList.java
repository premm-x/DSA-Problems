// solution - 3 ( brute, optimal, optimal + cleaner )

// brute for approch --- tc: O(n) sc: O(n)
class Solution {
    Queue<TreeNode> q = new ArrayDeque<>();
  
    void helper(TreeNode root){
        if(root == null) return;

        q.offer(root);
        helper(root.left);
        helper(root.right);
    }

    public void flatten(TreeNode root) {
        helper(root);
        root = q.poll();
      
        while(!q.isEmpty()){
            root.right = q.poll();
            root.left = null;
            root = root.right;
        }
    }
}

//----------------------------- ( 2 ) ---------------------------------
// my logic -- optimal --- tc: O(n) sc: O(1)
class Solution {
    
    TreeNode helper(TreeNode root){
        if(root == null) return null;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if((left != null && right != null) || (left != null && right == null)){
            root.right = left;
            root.left = null;

            while(left.right != null) left = left.right;

            left.right = right;
            left.left = null;
        }

        return root;
    }

    public void flatten(TreeNode root) {
        helper(root);
    }
}


//------------------------------ ( 3 ) ----------------------------------
// same opposite direction of 2 ( more cleaner to read ) --- optimal --- tc: O(n) sc: O(1)
class Solution {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}

