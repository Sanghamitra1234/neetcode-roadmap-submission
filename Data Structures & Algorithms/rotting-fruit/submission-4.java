class Solution {
    private int [][] p = {{1,0}, {0,1}, {0,-1}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        int totalTime = 0;
        int freshBanana = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                }
                if (grid[i][j] == 1) {
                    freshBanana++;
                }
            }
        }

        if (freshBanana == 0) return 0;

        while (!q.isEmpty()) {
            if (freshBanana == 0) {
                return totalTime;
            }
            int [] node = q.poll();
            int row = node[0];
            int col = node[1];
            int time = node[2];

            for (int i = 0; i < p.length; i++) {
                int x = row + p[i][0];
                int y = col + p[i][1];

                if (x >= 0 && x < m
                    && y >= 0 && y < n && grid[x][y] == 1) {
                        freshBanana--;
                        totalTime = Math.max(time + 1, totalTime);
                        grid[x][y] = -1;
                        q.offer(new int[]{x, y, time + 1});
                    }
            }
        }

        return freshBanana == 0 ? totalTime : -1;
    }
}
