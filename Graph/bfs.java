// solution - 2
// iterative and recursive 

// iterative one -----------------------------
        void bfs(ArrayList<Node> graph[], int node) {
            boolean visited[] = new boolean[graph.length];

            Queue<Integer> q = new ArrayDeque<>();
            q.add(node);
            visited[node] = true;

            while (!q.isEmpty()) {
                int curr = q.poll();

                System.out.print(curr + " ");

                for (int i = 0; i < graph[curr].size(); i++) {
                    Node n = graph[curr].get(i);

                    if (visited[n.des] == false) {
                        q.add(n.des);
                        visited[n.des] = true;
                    }
                }
            }
        }

// recursive one  -----------------------------

        void bfsRecursive(ArrayList<Node> graph[], Queue<Integer> q, boolean[] visited) {
            if(q.isEmpty()) return;

            int curr = q.poll();

            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Node n = graph[curr].get(i);

                if (!visited[n.des]) {
                    q.add(n.des);
                    visited[n.des] = true;
                }
            }
            
            bfsRecursive(graph, q, visited);

            //need to do this first in main function
                // Queue<Integer> q = new ArrayDeque<>();
                // q.add(0);
                // visited[0] = true;
                // g.bfsRecursive(graph, q, visited);
        }


