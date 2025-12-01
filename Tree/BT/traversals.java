//----------------- ( remaining ) -----------------
// zig-zag-order -- (recursion)
// vertical-order -- (recursion)
//-------------------------------------------------

//----------------- ( completed ) -----------------
// pre-order -- (recursion / iteration)
// in-order -- (recursion / iteration)
// post-order -- (recursion / iteration)
// level-order -- (recursion / iteration)
// vertical-order -- (iteration)
// diagonal-order -- (recursion / iteration)
// boundry-order -- (mix)
// zig-zag-order -- (iteration)
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
// ----------------------------------------------------------------------------------------
// ------------------------------- 1 ----------------------------------
// there is two way using bfs and dfs both gives different answer 
        
// diagonal trversel ( iterative ) based on level 
class Tree {
    
    class Pair{
        Node node;
        int dia;
        Pair(Node n, int d){ node = n; dia = d; }
    }
    
    public ArrayList<Integer> diagonal(Node root) {
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int d = p.dia;
            
            if(!map.containsKey(d)) map.put(d, new ArrayList<>());
            map.get(d).add(curr.data);
            
            if(curr.left != null) q.offer(new Pair(curr.left, d+1));
            if(curr.right != null) q.offer(new Pair(curr.right, d));
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(ArrayList<Integer> l : map.values()){
            ans.addAll(l);
        }
        
        return ans;
    }
}
        // ------------------------------- 2 ----------------------------------
// diagonal trversel ( recursive ) based on dfs 
class Tree {
    
    void maindiagonalRecusiveHelper(Node root, int level, TreeMap<Integer, ArrayList<Integer>> map){
        if(root == null) return;

        if(!map.containsKey(level)) map.put(level, new ArrayList<>());
        map.get(level).add(root.data);

        maindiagonalRecusiveHelper(root.left, level+1, map);
        maindiagonalRecusiveHelper(root.right, level, map);
    }

    public ArrayList<Integer> diagonal(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        maindiagonalRecusiveHelper(root, 0, map);
        
        for(ArrayList<Integer> l : map.values()){
            ans.addAll(l);
        }
        
        return ans;
    }
}
// ----------------------------------------------------------------------------------------
// boundry-order (mix) --- Time: O(n) Space: O(height) due to recursion (worst-case O(n))
// top left bottom right -- 4 direction
class Solution {
    
    void bottom(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }
            
        bottom(root.left, ans);
        bottom(root.right, ans);
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();
        
        if(!(root.left == null && root.right == null))
            ans.add(root.data);
        
        Node leftSide = root.left;
        
        while(leftSide != null && (leftSide.left != null || leftSide.right != null)){
            
            if(leftSide.left != null) {
                ans.add(leftSide.data);
                leftSide = leftSide.left;
            }
            else {
                ans.add(leftSide.data);
                leftSide = leftSide.right;
            }
        }
        

        bottom(root, ans);
        
        Node rightSide = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(rightSide != null && (rightSide.left != null || rightSide.right != null)){
            
            if(rightSide.right != null) {
                temp.add(rightSide.data);
                rightSide = rightSide.right;
            }
            else {
                temp.add(rightSide.data);
                rightSide = rightSide.left;
            }
        }
        
        Collections.reverse(temp);
        ans.addAll(temp);
        
        return ans;
    }
}

// ---------------------------------------- (  zig-zag-order ) ------------------------------------------------
// zig-zag-order -- (iteration) --- 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> order = new ArrayDeque<>();
        order.offer(root);

        boolean turn = false;

        while(!order.isEmpty()){

            int size = order.size();
            List<Integer> eachLevel = new ArrayList<>();

            for(int i=0; i<size; i++){

                TreeNode temp = order.poll();

                if(temp.left != null) order.offer(temp.left);
                if(temp.right != null) order.offer(temp.right);

                eachLevel.add(temp.val);
            }

            if(turn){
                Collections.reverse(eachLevel);
            }
            ans.add(eachLevel);

            turn = !turn;
        }

        return ans;
    }
}

    }



