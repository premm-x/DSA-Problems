
//---------------- ( remaiming ) ------------------
// balance
// diameter

//---------------- ( completed ) ------------------
// height
// count all node
// count Leaf Node
// check Two Tree Are Identical
// subtree In Another Tree
// mirror Tree
//-------------------------------------------------

// height
int height(Node root){
    if(root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
}

// count all node     
int count(Node root){
    if(root == null) return 0;
    return count(root.left) + count(root.right) + 1;
}

// count Leaf Node
int countLeafNode(Node root){
    if(root == null) return 0;
    if(root.left == null && root.right == null) return 1;
    return countLeafNode(root.left) + countLeafNode(root.right);
}

// check Two Tree Are Identical
boolean checkTwoTreeAreIdentical(Node root1, Node root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;

    return root1.val == root2.val &&
            checkTwoTreeAreIdentical(root1.left, root2.left) &&
            checkTwoTreeAreIdentical(root1.right, root2.right);
}

// subtree In Another Tree
boolean subtreeInAnotherTree(Node root1, Node root2) {
    // only exact subtree (leaf node) work without children only
    if (root1 == null) return false;
    if (checkTwoTreeAreIdentical(root1, root2)) return true;

    return subtreeInAnotherTree(root1.left, root2) || subtreeInAnotherTree(root1.right, root2);
}

// mirror Tree
Node mirrorTree(Node root) {
    if (root == null) return null;

    Node left = mirrorTree(root.left);
    root.left = mirrorTree(root.right);
    root.right = left;

    return root;
}

