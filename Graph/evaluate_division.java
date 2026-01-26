// solution - 1

// ----------------------------------- ( 1 ) ----------------------------------------
// brute force --- tc: O(Q × (V + E))  sc: O(V + E)
class Solution {

    class Pair{
        String first;
        double second;
        Pair(String f, double s){
            first = f;
            second = s;
        }
    }
    
    double value = -1.0;

    void dfs(HashMap<String, ArrayList<Pair>> map, String u, String v, 
    
    HashSet<String> visited, double product){

        if(visited.contains(u)) return ;

        visited.add(u);

        if(u.equals(v)){
            value = product;
            return;
        }
        
        for(Pair e : map.get(u)){
            String des = e.first;
            double val = e.second;

            dfs(map, des, v, visited, product*val);
        }

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, ArrayList<Pair>> map = new HashMap<>();

        int idx = 0;
        for(List<String> e : equations){
            String a = e.get(0);
            String b = e.get(1);
            
            if(!map.containsKey(a))
                map.put(a, new ArrayList<>());

            ArrayList list = map.get(a);
            list.add(new Pair( b, values[idx] ));
            map.put(a, list);

            if(!map.containsKey(b))
                map.put(b, new ArrayList<>());

            list = map.get(b);
            list.add(new Pair( a, 1.0/values[idx++] ));

            map.put(b, list);
        }

        double[] ans = new double[queries.size()];

        int i = 0;
        for(List<String> q : queries){
            String u = q.get(0);
            String v = q.get(1);
            value = -1.0;
            double product = 1.0;

            if(map.containsKey(u)){
                HashSet<String> visited = new HashSet<>();
                dfs(map, u, v, visited, product);
            }

            ans[i++] = value;
        }

        return ans;
    }
}









