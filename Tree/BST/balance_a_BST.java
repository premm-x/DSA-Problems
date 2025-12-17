// solution - 1

// inorder + binary search technique  ---- tc: O(n) sc: O(n)
class Solution {
    
    void inOrder(TreeNode root, ArrayList<Integer> pre){
        if(root == null) return;

        inOrder(root.left, pre);
        pre.add(root.val);
        inOrder(root.right, pre);
    }

    TreeNode build(ArrayList<Integer> pre, int st, int end){
        if(st > end) return null;

        int mid = st + (end- st) / 2;

        TreeNode root = new TreeNode(pre.get(mid));

        root.left = build(pre, st, mid-1);
        root.right = build(pre, mid+1, end);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<>();;
        inOrder(root, pre);
        return build(pre, 0, pre.size()-1);
    }
}


