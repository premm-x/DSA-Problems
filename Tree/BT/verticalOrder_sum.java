// solution - 1

// bfs --- tc: O(n) or maybe O(nlogn) sc: O(n)
class Solution {
    
    class Triple{
        Node node;
        int zone;
        Triple(Node n, int z){ node = n; zone = z;}
    }
    
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Triple> q = new ArrayDeque<>();

        q.add(new Triple(root, 0));

        while(!q.isEmpty()){
            Triple t = q.poll();
            Node currNode = t.node;
            int zone = t.zone;

            map.put(zone, map.getOrDefault(zone, 0) + currNode.data);

            if(currNode.left != null) q.add(new Triple(currNode.left, zone-1));
            if(currNode.right != null) q.add(new Triple(currNode.right, zone+1));
        }
        
        for(Integer val : map.values()){
            ans.add(val);
        }

        return ans;
    }
}










