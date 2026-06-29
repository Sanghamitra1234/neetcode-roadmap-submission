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
    public int minMeetingRooms(List<Interval> intervals) {
        // line sweep algo
        int [] start = new int [intervals.size()];
        int [] end = new int [intervals.size()];
        int count = 0;
        int res = 0;

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0;

        while (s < intervals.size() && e < intervals.size()) {
            if (start[s] < end[e]) {
                s++;
                count++;
                res = Math.max(count, res);
            } else {
                e++;
                count--;
            }
        }
        return res;

    }
}

// [(0,40),(5,10),(15,20)]

// 0,5,15
// 10,20,40
