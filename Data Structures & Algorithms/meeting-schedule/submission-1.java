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

        intervals.sort((a,b) -> Integer.compare(a.start,b.start));

        boolean ans = true;

        for(int i = 1;i < intervals.size();i++)
        {
            Interval currMeeting = intervals.get(i);
            Interval prevMeeting = intervals.get(i-1);

            if(prevMeeting.end > currMeeting.start)
            {
                ans = false;
                break;
            }
        }

        return ans;
    }
}
