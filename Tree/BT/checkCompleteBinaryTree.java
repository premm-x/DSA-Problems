// check Complete BinaryTree ( using level order technique )

      boolean isCompleteBT(Node root) {
            if(root == null) return true;
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            boolean seenNull = false;
            while (!q.isEmpty()) {
                Node curr = q.poll();
                
                if(curr == null){
                    seenNull = true;
                    continue;
                }

                if(seenNull) return false;

                q.add(curr.left);
                q.add(curr.right);
            }
            return true;
        }
