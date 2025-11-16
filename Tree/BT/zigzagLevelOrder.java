// zigzag level order ( using leve order technique ) 

      List<List<Integer>> zigzagLevelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);

            boolean leftToRight = true;
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    if (leftToRight)
                        temp.addLast(curr.val);
                    else
                        temp.addFirst(curr.val);

                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                }
                ans.add(temp);
                leftToRight = !leftToRight;
            }
            return ans;
        }
