// solution - 1

// dfs -- parent comapre approch
boolean unDirCycle(ArrayList<Node> graph[], int start, int parent, boolean[] visited ){
            if(!visited[start]){
                System.out.print(start + " ");
                visited[start] = true;
                
                for(int i=0; i<graph[start].size(); i++){
                    Node curr = graph[start].get(i);

                    if(visited[curr.des] && curr.des != parent) return true;
                    
                    if(unDirCycle(graph, curr.des, start, visited))
                        return true;
                }
            }
            return false;
        }
