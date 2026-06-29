class Solution {
   
    private static final int[][] directions = {{1, 0}, {-1, 0},{0, 1}, {0, -1}};
    boolean[][] vis;
    int count = 0;
    public int numIslands(char[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c, boolean[][] vis) {
        
        for (int i = 0; i < directions.length; i++) {
            int x = r + directions[i][0];
            int y = c + directions[i][1];
            if (isSafe(grid, x, y, vis)) {
                vis[x][y] = true;
                dfs(grid, x, y, vis);
            }

        }

    }

    public boolean isSafe(char[][] grid, int r, int c, boolean[][] vis) {
        if (r < 0 || c < 0 || r >= grid.length ||
            c >= grid[0].length || grid[r][c] == '0' || vis[r][c]) {
            return false;
        }
        return true;
    }
}
