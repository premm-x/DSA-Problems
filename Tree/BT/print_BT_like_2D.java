// solution - 1

// both ( bfs ) and ( dfs ) solution here --- tc: O(n) sc: O(n)
// mid, boundry, hieght, width ( column ) of tree info collected
class Solution {

    class NodeInfo{
        TreeNode node;
        int row, left, right;
        NodeInfo(TreeNode n, int r, int l, int rt){
            node = n;
            row = r;
            left = l;
            right = rt;
        }
    }
    
    void dfs(TreeNode root, List<List<String>> res, int row, int left, int right){
        if(root == null || row == res.size()) return;

        int mid = (left + right) / 2;

        res.get(row).set(mid, Integer.toString(root.val));

        dfs(root.left, res, row+1, left, mid-1);
        dfs(root.right, res, row+1, mid+1, right);
    }

    int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        int row = height(root);
        int col = (1 << row ) - 1;
        
        List<List<String>> res = new ArrayList<>();

        for(int i=0; i<row; i++){
            List<String> temp = new ArrayList<>();
            for(int  j=0; j<col; j++) temp.add("");
            res.add(temp);
        }

        // both bfs and dfs are here 
        // use anyone by commenting anyone of them

        // ------- dfs
        // dfs(root, res, 0, 0, col-1);

        // ------- bfs
        Queue<NodeInfo> q = new ArrayDeque<>();
        q.add(new NodeInfo(root, 0, 0, col-1));

        while(!q.isEmpty()){
            NodeInfo curr = q.poll();
            
            int mid = (curr.left + curr.right) / 2;
            res.get(curr.row).set(mid, String.valueOf(curr.node.val));

            if(curr.node.left != null)
                q.add(new NodeInfo(curr.node.left, curr.row+1, curr.left, mid-1));

            if(curr.node.right != null)
                q.add(new NodeInfo(curr.node.right, curr.row+1, mid+1, curr.right));
        }

        return res;
    }
}
