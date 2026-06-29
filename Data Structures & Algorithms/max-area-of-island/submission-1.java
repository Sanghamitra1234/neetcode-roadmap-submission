class Solution {
    private int [][] possibleDirections ={{1,0}, {-1,0},{0,1}, {0,-1}};
    // {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int [][] visited;
    private int maxArea = 0;
    private int localArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        visited = new int [x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    localArea = 0;
                    area(grid, i, j, visited);
                    maxArea = Math.max(localArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    public void area(int[][] grid, int row, int col, int [][] visited) {
        System.out.println( row + " "+ col);
        localArea++;
        visited[row][col] = 1;
        for (int i = 0; i < possibleDirections.length; i++) {
            int x = row + possibleDirections[i][0];
            int y = col + possibleDirections[i][1];
            if (isSafe(grid, x, y, visited)) {
                area(grid, x, y, visited);
            }
        }
        return;
    }

    public boolean isSafe(int[][] grid, int row, int col, int [][] visited) {
        if (row < 0 || col < 0 || row >= grid.length 
            || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == 0) {
                return false;
            }
        return true;
    }
}
