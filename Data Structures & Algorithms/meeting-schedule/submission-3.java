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

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (currentInterval.start < end) {
                return false;
            }
            end = currentInterval.end; 
        }

        return true;
    }
}
