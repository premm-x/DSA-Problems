
//---------------- ( remaiming ) ------------------
// balance
// diameter

//---------------- ( completed ) ------------------
// height
// count all node
// count Leaf Node
//-------------------------------------------------

int height(Node root){
    if(root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
}
        
int count(Node root){
    if(root == null) return 0;
    return count(root.left) + count(root.right) + 1;
}

int countLeafNode(Node root){
    if(root == null) return 0;
    if(root.left == null && root.right == null) return 1;
    return countLeafNode(root.left) + countLeafNode(root.right);
}

