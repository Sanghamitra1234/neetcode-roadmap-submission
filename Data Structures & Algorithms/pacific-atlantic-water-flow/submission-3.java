class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int [][] directions = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    boolean isPacific = false;
    boolean isAtlantic = false;
    Set<String> visited = new HashSet<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        for (int i = 0 ; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                isPacific = false;
                isAtlantic = false;
                dfs(i, j, heights);
                visited.clear();
                if (isPacific && isAtlantic) {
                     answer.add(Arrays.asList(i, j));
                }
            }
        }

        return answer;
        
    }

    public void dfs(int x, int y, int[][] heights)  {
        String key = x + "," +y;
        if (visited.contains(key)){
            return;
        }

        visited.add(key);
        if (y >= heights[0].length - 1 || x >= heights.length - 1) {
            isAtlantic = true;
        }

        if (x == 0 || y == 0) {
            isPacific = true;
        }


        for (int i = 0; i < directions.length; i++) {
            int dx = x + directions[i][0];
            int dy = y + directions[i][1];

            if (isNextPath(dx, dy, heights[x][y], heights)) {
                dfs(dx, dy, heights);
            }
        }
        return;
    }

    public boolean isNextPath(int x, int y, int h, int[][] heights) {
        return (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length
        && h >= heights[x][y]);
    }
}
