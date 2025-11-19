
//--------------- ( remaining ) --------------
// delete ( iterative )
//--------------------------------------------

//--------------- ( completed ) --------------
// search ( recursive / iterative )
// insert ( recursive / iterative )
// delete ( recursive )
//--------------------------------------------

static class BinarySearchTree{
        // search iterative
        boolean search(Node root, int target){
            while(root != null){
                if(target == root.val) return true;
                else if (target < root.val) root = root.left;
                else root = root.right;
            }
            return false;
        }
  
        // search recursive
        boolean searchRecursive(Node root, int target){
            if(root == null) return false;

            if(target == root.val) return true;
            else if (target < root.val) return search(root.left, target);
            else return search(root.left, target);
        }
        
        // insert ( iterative )
        void inseart(Node root, int val){
            if(root == null) return;
            Node node = null;

            while (root != null) {
                node = root;
                if(val < root.val) root = root.left;
                else if(val > root.val) root = root.right;
                else return;
            }

            if(val < node.val && node.left == null) node.left = new Node(val);
            else node.right = new Node(val);
        }

        // insert ( recursive )
        Node insert(Node root, int val){
            if(root == null) return new Node(val);

            if(val < root.val) root.left = insert(root.left, val);
            else if(val > root.val) root.right = insert(root.right, val);

            return root;
        }
        
        // delete ( recursive )
        Node delete(Node root, int val){
            if(root == null) return null;
            
            if(val < root.val) root.left = delete(root.left, val);
            else if(val > root.val) root.right = delete(root.right, val);
            else{

                if(root.left == null) return root.right;
                if(root.right == null) return root.left;

                Node node = root.right;
                while(node.left != null) node = node.left;
                root.val = node.val;

                root.right = delete(root.right, node.val);
                
            }
            return root;
        }


    }
