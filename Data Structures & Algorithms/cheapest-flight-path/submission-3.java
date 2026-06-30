class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // build adjacency list for easy traversal
        List<List<int []>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int [] flight = flights[i];
            adjacencyList.get(flight[0]).add(flight);
           
        }
        // int [] -> {wt, node, k}
        PriorityQueue <int []> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, -1});
        int [] cost = new int[n];
        Arrays.fill(cost,  Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int [] nodeDetails = pq.poll();
            int weight = nodeDetails[0];
            int node = nodeDetails[1];
            cost[node] = weight;
            if (node == dst) {
                return weight;
            }
            int stops = nodeDetails[2];
            if (stops >= k) continue;
            for (int i = 0; i < adjacencyList.get(node).size(); i++) {
                int [] adjListNode = adjacencyList.get(node).get(i);
                if (cost[adjListNode[1]] >= adjListNode[2] + weight) {
                    pq.add(new int[]{
                        adjListNode[2] + weight, 
                        adjListNode[1], 
                        stops + 1
                    });
                }
            }

        }
        return -1;
    }
}
