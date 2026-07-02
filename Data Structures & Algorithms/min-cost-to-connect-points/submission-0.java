class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 0;
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int [] visited = new int [n];
        int sum = 0;
        pq.add(new int[]{0,0});

        while (!pq.isEmpty()) {
            int [] p = pq.poll();
            if ( visited[p[1]] != 0) {
                continue;
            }
            visited[p[1]] = 1;
            sum += p[0];

            List<int[]> adjList = adj.get(p[1]);
            //System.out.println(p[1]);
            for (int i = 0; i < adjList.size(); i++) {
                int [] point = adjList.get(i);
                if (visited[point[1]] != 1) {
                    pq.add(new int[]{point[0],point[1]});
                }
            }
        }
        return sum;
    }
}
