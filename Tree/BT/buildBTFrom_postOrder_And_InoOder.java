// solution - 1

// recursive + HashMap --- tc: O(n) sc: O(n)

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;

    TreeNode build(int[] post, int st, int end){
        if(st > end) return null;

        int rootVal = post[(post.length-1) - idx++];
        int rootIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.right = build(post, rootIndex+1, end);
        root.left = build(post, st, rootIndex-1);

        return root;
    }

    public TreeNode buildTree(int[] in, int[] post) {
        for(int i=0; i<in.length; i++) map.put(in[i], i);
        return build(post, 0, in.length-1);
    }
}

