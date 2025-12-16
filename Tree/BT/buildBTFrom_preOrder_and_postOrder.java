// solution - 1

// recursive + HashMap --- tc: O(n) sc: O(n)
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    private TreeNode build(int[] pre, int st, int end){
        if(st > end || idx >= pre.length) return null;

        TreeNode root = new TreeNode(pre[idx++]);

        if(st == end) return root;

        int leftRoot = pre[idx];
        int leftRootIndex = map.get(leftRoot);

        int leftSize = leftRootIndex - st + 1;

        root.left = build(pre, st, st + leftSize - 1);
        root.right = build(pre, st + leftSize, end - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for(int i=0; i<post.length; i++) map.put(post[i], i);
        return build(pre, 0, post.length-1);
    }
}


