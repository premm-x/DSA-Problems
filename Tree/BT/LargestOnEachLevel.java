
// Largest number On Each Level ( using level order technique )

      List<Integer> largestEachLevel(Node root){
            List<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                int max = Integer.MIN_VALUE;
                for(int i=0; i<size; i++){
                    Node curr = q.poll();
                    max = Math.max(max, curr.val);
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                }
                ans.add(max);
            }            
            return ans;
        }
