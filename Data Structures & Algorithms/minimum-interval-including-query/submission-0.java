class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int j = 0; j < queries.length; j++) {
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] <= queries[j] && queries[j] <= intervals[i][1]) {
                    int len = intervals[i][1] - intervals[i][0] + 1;
                    minLen = Math.min(minLen, len);
                } else {
                    continue;
                }
            }
            res[j] = minLen == Integer.MAX_VALUE ? -1 : minLen;
        }
        return res;
    }
}
