class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int [][] query = new int [queries.length][queries.length];

        for (int i = 0; i < query.length; i++) {
            query[i][0] = queries[i];
            query[i][1] = i;
        }

        Arrays.sort(query, (a, b) -> a[0] - b[0]);

        int i = 0;
        for (int j = 0; j < query.length; j++) {
            int qval = query[j][0];
            while (i < intervals.length && intervals[i][0] <= qval ) {
                int size = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{size, intervals[i][1]});
                i++;
            }
            System.out.println(qval + " "+ pq.peek() + " "+ i);
            while (!pq.isEmpty() && pq.peek()[1] < qval) {
                pq.poll();
            }
            int index = query[j][1];
            res[index] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return res;
    }
}
