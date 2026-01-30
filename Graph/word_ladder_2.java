// solution - 1

// bfs + dfs approch ( parent stored for traversel ) --- tc: O(N * L * output size) ( O(N*L*dfs) ),  sc: O(O(N × L)
)
class Solution {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> parent = new HashMap<>();

    void dfs(String start, String word, ArrayList<String> path){
        if(word.equals(start)){
            ArrayList<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        for(String p : parent.get(word)){
            path.add(p);
            dfs(start, p, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> findLadders(String start, String end, List<String> list) {
        int n = list.size();
        
        Set<String> dict = new HashSet<>(list);
        if(!dict.contains(end)) return result;

        Queue<String> q = new ArrayDeque<>();
        q.add(start);

        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);

        for(String s : dict) parent.put(s, new ArrayList<>());
        parent.put(start, new ArrayList<>());

        while (!q.isEmpty()) {
            String curr = q.poll();

            int d = dist.get(curr);

            char[] arr = curr.toCharArray();

            for (int j=0; j<arr.length; j++) {
                char old = arr[j];

                for(char k='a'; k<='z'; k++){
                    arr[j] = k;

                    String next = new String(arr);

                    if(!dict.contains(next)) continue;

                    if(!dist.containsKey(next)){
                        dist.put(next, d+1);
                        q.add(next);
                        parent.get(next).add(curr);
                    }
                    else if(dist.get(next) == d+1){
                        parent.get(next).add(curr);
                    }
                }
                arr[j] = old;
            }

        }
        
        if(!dist.containsKey(end)) return result;

        ArrayList<String> path = new ArrayList<>();
        path.add(end);
        dfs(start, end, path);

        return result;
    }
}

