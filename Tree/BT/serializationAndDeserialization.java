// solution - 2 (bfs, dfs)

// bfs --- tc: O(n) sc: O(n)
public class Codec {

    public String serialize(TreeNode root) {
        String s = "";
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if(curr == null){
                s = s + "#,"; 
                continue;
            }
            else s = s + curr.val + ",";

            q.add(curr.left);
            q.add(curr.right);
        }
        return s;
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String[] val = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int i = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!val[i].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(val[i]));
                q.add(curr.left);
            }
            i++;

            if(!val[i].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(val[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

//----------------------------------- ( 2 ) ----------------------------------------
// dfs  --- tc: O(n) sc: O(n)
public class Codec {

    String s = "";
    public String serialize(TreeNode root) {
        if (root == null) return s = s + "#,";

        s = s + root.val + ",";

        serialize(root.left);
        serialize(root.right);

        return s;
    }
    
    int idx = -1;

    TreeNode build(String[] val){
        idx++;

        if(val[idx].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val[idx]));

        root.left = build(val);
        root.right = build(val);

        return root;
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String val[] = data.split(",");

        return build(val);
    }
}

