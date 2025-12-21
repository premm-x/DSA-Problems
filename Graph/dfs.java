// solution - 2
// recursive and iterative

// recursive one  -----------------------------
void dfs(ArrayList<Node> graph[], int node, boolean[] visited) {

            if (visited[node] == false) {
                System.out.print(node + " ");
                visited[node] = true;

                for (int i = 0; i < graph[node].size(); i++) {
                    Node n = graph[node].get(i);
                    dfs(graph, n.des, visited);
                }
            }
      }

// iterative one -----------------------------

        void dfsIterative(ArrayList<Node> graph[], int start, boolean[] visited) {
            Stack<Integer> stack = new Stack<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                int node = stack.pop();

                if (!visited[node]) {
                    visited[node] = true;
                    System.out.print(node + " ");

                    // push neighbors
                    for (int i = 0; i < graph[node].size(); i++) {
                        Node n = graph[node].get(i);

                        if (!visited[n.des]) {
                            stack.push(n.des);
                        }
                    }
                }
            }
        }



