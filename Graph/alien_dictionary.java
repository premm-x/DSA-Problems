// solution - 1

// optimal --- tc: O(N × maxWordLength + E)  sc: O(n × m)
// simplification -- tc O(n × m + E)  →  O(n × m)

class Solution {
    
    public String findOrder(String[] words) {
        
        int n = words.length;
       
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<26; i++) graph.add(new ArrayList<>());
        
        int[] indegree = new int[26];
        boolean[] present = new boolean[26];
        
        for (String w : words) {
            for (char ch : w.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }
        
        for(int i=0; i<n-1; i++){
            
            String s1 = words[i];
            String s2 = words[i+1];
            
            int j = 0, k = 0;
            
            while(j < s1.length() && k < s2.length() && s1.charAt(j) == s2.charAt(k)){
                j++; k++;
            }
            
            if (j < s1.length() && j == s2.length()) return "";
            if(j >= s1.length()) continue;
            
            graph.get( s1.charAt(j) - 'a' ).add( s2.charAt(k) - 'a');
            
            indegree[ s2.charAt(k) - 'a' ]++;
        }
        
        String ans = "";
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<26; i++){
            if(present[i] && indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            char c = (char) ('a' + curr);
            ans += c;
            
            for(int v : graph.get(curr)){
                indegree[v]--;
                
                if(indegree[v] == 0) q.add(v);
            }
            
        }
        
        return ans.length() == countPresent(present) ? ans : "";
    }
    
    int countPresent(boolean[] present){
        int c = 0;
        for(boolean i : present) if(i) c++;
        return c;
    }
    
}




