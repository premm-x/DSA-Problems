
// ---------------- ( remaining ) --------------
// top-view
// bottom-view
// ---------------------------------------------

// ---------------- ( completed ) --------------
// left-view
// right-view
// ---------------------------------------------

// left-view
List<Integer> leftView(Node root){
      List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                Node curr = q.poll();
                if(i == 0) ans.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return ans;
}

// right-view
List<Integer> rightView(Node root){
      List<Integer> ans = new ArrayList<>();
      if(root == null) return ans;
      Queue<Node> q = new ArrayDeque<>();
      q.add(root);

      while (!q.isEmpty()) {
          int size = q.size();
          for(int i=0; i<size; i++){
              Node curr = q.poll();
              if(i == 0) ans.add(curr.val);  //1.you track last element (size-1)

              if(curr.left != null) q.add(curr.left);  //2.or change level order direction
              if(curr.right != null) q.add(curr.right);  //right to left
          }
      }
      return ans;
}
