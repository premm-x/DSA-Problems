//----------------- ( remaining ) -----------------
// level-order -- (recursion / iteration)
// zig-zag-order -- (recursion / iteration)
// boundry-order -- (recursion / iteration)
// vertical-order -- (recursion / iteration)
//-------------------------------------------------

//----------------- ( completed ) -----------------
// pre-order -- (recursion / iteration)
// in-order -- (recursion / iteration)
// post-order -- (recursion / iteration)
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

    }



