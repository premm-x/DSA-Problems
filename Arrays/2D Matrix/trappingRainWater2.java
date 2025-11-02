// solution - 1
// priorityQueue + bfs --- tc: O(m*n * log(m*n)  sc: O(m*n);

class Solution {
    
    boolean isValid(int r, int c, int m, int n){
        return (r >= 0 && r < m && c >= 0 && c < n);
    }

    public int trapRainWater(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        
        if(m < 3 || n < 3) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        boolean visited[][] = new boolean[m][n];

        for(int i=0; i<m; i++){
            pq.offer(new int[]{map[i][0], i, 0});
            pq.offer(new int[]{map[i][n-1], i, n-1});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for(int i=0; i<n; i++){
            pq.offer(new int[]{map[0][i], 0, i});
            pq.offer(new int[]{map[m-1][i], m-1, i});
            visited[0][i] = true;
            visited[m-1][i] = true;
        }

        int water = 0;
        int dir[] = {-1, 0, 1, 0, -1};

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int hieght = curr[0];
            int r = curr[1];
            int c = curr[2];
                        
            for(int i=0; i<4; i++){
                int newR = r + dir[i];
                int newC = c + dir[i+1];
                
                if(isValid(newR, newC, m, n) && !visited[newR][newC]){
                    visited[newR][newC] = true;
                    water += Math.max( hieght - map[newR][newC], 0);
                    pq.offer(new int[]{Math.max(map[newR][newC], hieght), newR, newC});
                }
            }

        }

        return water;
    }
}
