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

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        //Extract start and end times in a new array
        for(int i = 0;i<n;i++)
        {
            Interval in = intervals.get(i);
            start[i] = in.start;
            end[i] = in.end;
        }
        //Sort in ascending order
        Arrays.sort(start);
        Arrays.sort(end);

        int maxCount = 0, count = 0;

        int i = 0, j = 0;

        while(i < n && j < n)
        {
            //Means a new meeting is started
            if(start[i] < end[j])
            {
                //need a new room
                count++;
                //Take the max
                maxCount = Math.max(maxCount,count);
                i++;
            }
            else
            {
                //A meeting ended so room vacated
                count--;
                j++;
            }
        }

        return maxCount;
    }
}
