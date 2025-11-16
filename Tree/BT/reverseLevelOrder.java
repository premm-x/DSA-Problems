// reverse Level Order ( using level order technique )

      List<List<Integer>> reverseLevelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> temp = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    temp.add(curr.val);
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                }
                ans.addFirst(temp);
            }
            return ans;
        }
