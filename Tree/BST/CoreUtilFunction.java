
//--------------- ( remaining ) --------------
// insert ( iterative )
// delete ( recursive / iterative )
//--------------------------------------------

//--------------- ( completed ) --------------
// search ( recursive / iterative )
// insert ( recursive )
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

        // insert ( recursive )
        Node insert(Node root, int val){
            if(root == null) return new Node(val);

            if(val < root.val) root.left = insert(root.left, val);
            else if(val > root.val) root.right = insert(root.right, val);

            return root;
        }

    }
