// solution - 1

// dsf
        void pathBetweenTwoNodes(ArrayList<Node> graph[], int source, int trg, boolean[] visited,
                ArrayList<Integer> st) {

            st.add(source);
            visited[source] = true;

            if (source == trg) {
                System.out.println(st);
                return;
            }

            for (int i = 0; i < graph[source].size(); i++) {
                Node curr = graph[source].get(i);

                if (!visited[curr.des]) {
                    pathBetweenTwoNodes(graph, curr.des, trg, visited, st);
                    if (!st.isEmpty())
                        st.removeLast();
                    visited[curr.des] = false;
                }
            }

        }
