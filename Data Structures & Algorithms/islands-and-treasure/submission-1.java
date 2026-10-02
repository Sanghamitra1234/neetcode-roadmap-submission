class Solution {

    public void islandsAndTreasure(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int [][] vis = new int [grid.length][grid[0].length];
        int [][] dx = {{1,0}, {0,1}, {0,-1}, {-1,0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int [] {i, j, 0});
                    vis[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            int [] node = q.poll();
            int i = node[0];
            int j = node[1];
            int time = node[2];

            for (int k = 0; k < dx.length; k++) {
                int di = i + dx[k][0];
                int dj = j + dx[k][1];

                if (di >= 0 && dj >= 0 
                    && di < grid.length && dj < grid[0].length
                    && grid[di][dj] == 2147483647) {
                    grid[di][dj] = time + 1;
                    q.add(new int [] {di, dj, time + 1});
                    vis[di][dj] = 1;
                }
            }
        }
    }

}
