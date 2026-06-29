class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(new int [] {intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int [] lastInterval = res.get(res.size() - 1);
            int s1 = lastInterval[0];
            int e1 = lastInterval[1];

            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (s2 < e1) {
                res.remove(res.size() - 1);
                res.add (new int [] {
                    Math.min(s1,s2), 
                    Math.min(e1,e2)});
                count++;
            } else {
                res.add (new int[] {s2, e2});
            }
        }
        // res.toArray(new int[res.size()][]);
        return count;
    }
}
