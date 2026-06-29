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
       if (intervals.size() == 0) {
            return 0;
        }

        int len = intervals.size();
        int[] startTime = new int[len];
        int[] endTime = new int[len];

        for (int i = 0; i < len; i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);


        int start = 0;
        int end = 0;
        int count = 0;
        int res = 0;
        while (start < startTime.length) {
            if (startTime[start] < endTime[end]) {
                start++;
                count++;
            } else {
                end++;
                count--;
            }
            res = Math.max(count, res);
        }

        return res;
    }
}
