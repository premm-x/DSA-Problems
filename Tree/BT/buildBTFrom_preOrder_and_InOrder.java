// solution - 1

// recursive + HashMap --- tc: O(n) sc: O(n)
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    
    TreeNode helper(int[] pre, int st, int end){
        if(st > end) return null;

        int rootNum = pre[idx++];
        int rootIndx = map.get(rootNum);

        TreeNode root = new TreeNode(rootNum);

        root.left = helper(pre, st, rootIndx-1);
        root.right = helper(pre, rootIndx+1, end);

        return root;
    }

    public TreeNode buildTree(int[] pre, int[] in) {

        for(int i=0; i<in.length; i++){
            map.put(in[i], i);
        }

        return helper(pre, 0, in.length-1);
    }
}




