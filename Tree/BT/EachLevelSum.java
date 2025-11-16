
// Each Level Sum ( using level order )

      List<Integer> levelSums(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null)
                return ans;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    sum += curr.val;

                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                }
                ans.add(sum);
            }
            return ans;
        }
