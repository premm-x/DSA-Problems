// solution - 1

// dfs -- recStack approch, path compare
boolean dirCycle(ArrayList<Node> graph[], int start, boolean[] visited, boolean[] recStack){
            if(!visited[start]){
                System.out.print(start + " ");
                visited[start] = true;
                recStack[start] = true;
                
                for(int i=0; i<graph[start].size(); i++){
                    Node curr = graph[start].get(i);

                    if(recStack[curr.des]) return true;

                    if(dirCycle(graph, curr.des, visited, recStack))
                        return true;
                }
            }
            recStack[start] = false;
            return false;
        }
