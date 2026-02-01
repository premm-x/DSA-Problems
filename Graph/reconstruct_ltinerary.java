// solution - 1

// dfs graph traversel + lexical order --- tc : O(V*E)  sc: O(V+E)
class Solution {
    void dfs(String curr, Map<String, List<String>> graph, ArrayList<String> path) {

        List<String> dests = graph.get(curr);
        while (dests != null && !dests.isEmpty()) {

            String next = dests.remove(0);
            dfs(next, graph, path);
          
        }

        path.addFirst(curr);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> t : tickets) {
            graph.computeIfAbsent(t.get(0), k -> new ArrayList<>()).add(t.get(1));
        }

        for (List<String> k : graph.values()) Collections.sort(k);

        ArrayList<String> path = new ArrayList<>();

        dfs("JFK", graph, path);

        return path;
    }
}


