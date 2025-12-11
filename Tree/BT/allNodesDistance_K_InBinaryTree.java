// solution - 1

// 3 way direction (map used for parent) left - right - parent (graph like) --- tc: O(n) sc: O(h)
class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    void addparent(TreeNode root, TreeNode parent){
        if(root == null) return;

        map.put(root, parent);

        addparent(root.left, root);
        addparent(root.right, root);
    }

    List<Integer> dfs(TreeNode root, int k){
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        visited.add(root);

        int dis = 0;

        while(!q.isEmpty()){
            int size = q.size();

            if(dis == k){
                List<Integer> ans = new ArrayList<>();
                for(TreeNode i : q) ans.add(i.val);
                return ans;
            }

            for(int i=0; i<size; i++){
                TreeNode currNode = q.poll();

                if(currNode.left != null && !visited.contains(currNode.left)){
                    visited.add(currNode.left);
                    q.add(currNode.left);
                }
                if(currNode.right != null && !visited.contains(currNode.right)){
                    visited.add(currNode.right);
                    q.add(currNode.right);
                }

                TreeNode p = map.get(currNode);
                if(p != null && !visited.contains(p)){
                    visited.add(p);
                    q.add(p);
                }
            }

            dis++;
        }
        return new ArrayList<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode trg, int k) {    
        addparent(root, null);
        return dfs(trg, k);
    }
}


