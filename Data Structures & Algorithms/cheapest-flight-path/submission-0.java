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
        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int [] nodeDetails = pq.poll();
            int weight = nodeDetails[0];
            int node = nodeDetails[1];
            if (node == dst) {
                return weight;
            }
            int stops = nodeDetails[2];
            //System.out.println(weight + " " + node + " " + stops);
            if (stops + 1 <= k + 1) {
                for (int i = 0; i < adjacencyList.get(node).size(); i++) {
                    int [] adjListNode = adjacencyList.get(node).get(i);
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
