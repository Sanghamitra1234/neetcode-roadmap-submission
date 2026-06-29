class Solution {
    private int [][] p = {{1,0}, {0,1}, {0,-1}, {-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                }     
            }  
         }

         while (!q.isEmpty()) {
            int [] node = q.poll();
            int row = node[0];
            int col = node[1];
            int time = node[2];

            for (int i = 0; i < p.length; i++) {
                int x = row + p[i][0];
                int y = col + p[i][1];

                if (x >= 0 && x < grid.length 
                    && y >=0 && y < grid[0].length && grid[x][y] == 2147483647) {
                        grid[x][y] = Math.min(time + 1, grid[x][y]);
                        q.offer(new int[]{x, y, time + 1});
                    }
            }
     }
            
    }

}
