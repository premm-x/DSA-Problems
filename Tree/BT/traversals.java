//----------------- ( remaining ) -----------------
// zig-zag-order -- (recursion / iteration)
// boundry-order -- (recursion / iteration)
// vertical-order -- (recursion)
//-------------------------------------------------

//----------------- ( completed ) -----------------
// pre-order -- (recursion / iteration)
// in-order -- (recursion / iteration)
// post-order -- (recursion / iteration)
// level-order -- (recursion / iteration)
// vertical-order -- (iteration)
//-------------------------------------------------
static class BinaryTree {
        // recursion
        void preOrder(Node root) {
            if (root == null)
                return;
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        void inOrder(Node root) {
            if (root == null)
                return;
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        void postOrder(Node root) {
            if (root == null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
        // iterative
        void inOrderIterative(Node root){
            Stack<Node> st = new Stack<>();
            Node curr = root;

            while(curr != null || !st.isEmpty()){
                while(curr != null){
                    st.push(curr);
                    curr = curr.left;
                }

                curr = st.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
        
        void inOrderIterative_2(Node root) {
            Stack<Node> st = new Stack<>();
            st.push(root);

            while (!st.isEmpty()) {

                Node curr = st.pop();

                while (curr != null) {
                    st.push(curr);
                    curr = curr.left;
                }

                if (!st.isEmpty()) {
                    curr = st.pop();
                    System.out.print(curr.val + " ");
                    st.push(curr.right);
                }
            }

        }

        void preOrderIterative(Node root){
            Stack<Node> st = new Stack<>();
            st.push(root);

            while(!st.isEmpty()){
                Node curr = st.pop();
                System.out.print(curr.val + " ");

                if(curr.right != null)st.push(curr.right);
                if(curr.left != null)st.push(curr.left);
            }
        }

        void postOrderIterative(Node root){
            
            Stack<Node> st1 = new Stack<>();
            Stack<Node> st2 = new Stack<>();
            st1.push(root);

            while(!st1.isEmpty()){
                Node curr = st1.pop();
                st2.push(curr);

                if(curr.left != null) st1.push(curr.left);
                if(curr.right != null) st1.push(curr.right);
            }
            while (!st2.isEmpty()) {
                System.out.print(st2.pop().val + " ");
            }
        }
        
        // level-order -- (iteration)
        List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>(); // used to return as list not compulsory
            Queue<Node> q = new ArrayDeque<>();

            if (root != null)
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
                ans.add(temp);
            }
            return ans;
        }
        // level-order -- (recursion)
        class levelOrderRec {
                void leftViewDFS(Node root, int level, List<Integer> ans, int[] maxLevel) {
                    if (root == null)
                        return;
        
                    if (level > maxLevel[0]) {
                        ans.add(root.val);
                        maxLevel[0] = level;
                    }
        
                    leftViewDFS(root.left, level + 1, ans, maxLevel);
                    leftViewDFS(root.right, level + 1, ans, maxLevel);
                }
        
                List<Integer> leftView(Node root) {
                    List<Integer> ans = new ArrayList<>();
                    int[] maxLevel = { 0 }; // using array to mutate inside recursion
                    leftViewDFS(root, 1, ans, maxLevel);
                    return ans;
                }
            }

// ---------------------------------------------
// vertical-order -- (bfs -- iteration )
class Solution {
    class Triple{
        TreeNode node;
        int zone;
        int level;
        Triple(TreeNode n, int z, int l){ node = n; zone = z; level = l; }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Triple> q = new ArrayDeque<>();

        q.add(new Triple(root, 0, 1));

        while(!q.isEmpty()){
            Triple t = q.poll();
            TreeNode currNode = t.node;
            int zone = t.zone;
            int level = t.level;

            if(!map.containsKey(zone)) map.put(zone, new ArrayList<>());
            map.get(zone).add(new int[]{ level, currNode.val });

            if(currNode.left != null) q.add(new Triple(currNode.left, zone-1, level+1));
            if(currNode.right != null) q.add(new Triple(currNode.right, zone+1, level+1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<int[]> list : map.values()){

            Collections.sort(list, (a, b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> col = new ArrayList<>();
            for(int[] arr : list) col.add(arr[1]);

            ans.add(col);
        }

        return ans;
    }
}


    }



