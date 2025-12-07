// solution - 1

// dfs --- tc: O(n) sc: O(n)
class Solution {
    void helper(TreeNode root, List<String> arr, String str){
        if(root == null) return;

        str += root.val;
        if(root.left == null && root.right == null) arr.add(str);
        
        helper(root.left, arr, str+"->");
        helper(root.right, arr, str+"->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr = new ArrayList<>();
        helper(root, arr, "");
        
        return arr;
    }
}
