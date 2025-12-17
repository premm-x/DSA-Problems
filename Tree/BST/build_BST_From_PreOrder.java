// solution - 1

// dfs + value checking  --- tc: O(n) sc: O(n)
class Solution {
    int idx = 0;
    TreeNode build(int[] pre, int min, int max){
        if(idx >= pre.length) return null;

        int val = pre[idx];
        if(val < min || val > max) return null;

        idx++;
        TreeNode root = new TreeNode(val);

        root.left = build(pre, min, root.val);
        root.right = build(pre, root.val, max);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
