/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int s1 = intervals.get(0).start;
        int e1 = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            int s2 = intervals.get(i).start;
            int e2 = intervals.get(i).end;

            if (s2 < e1) {
                s1 =  Math.min(s1,s2);
                e1 =  Math.min(e1,e2);
                return false;
            } else {
                s1 =  s2;
                e1 =  e2;
            }
        }
        // res.toArray(new int[res.size()][]);
        return true;
    }
}
