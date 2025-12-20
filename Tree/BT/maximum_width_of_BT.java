// solution - 1

// index calculation ( index using pairs ) ( bfs ) --- tc: O(n) sc: O(n)
class Solution {
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode n, int i){
            node = n;
            idx = i;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0, end = 0;
            int firstIdx = q.peek().idx;

            for(int i=0; i<size; i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                int idx = p.idx - firstIdx;
                
                if(i == 0) start = idx;
                if(i == size-1) end = idx;

                if(curr.left != null) q.add(new Pair(curr.left, 2*idx));
                if(curr.right != null) q.add(new Pair(curr.right, 2*idx+1));
            }
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}

