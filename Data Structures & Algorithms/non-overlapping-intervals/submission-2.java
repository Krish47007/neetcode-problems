class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int n = intervals.length;
        int prevEnd = intervals[0][1];
        int res = 0;

        for(int i = 1;i < n;i++)
        {
            int[] curr = intervals[i];
            //If no overlap update the prevEnd time
            if(prevEnd <= curr[0])
                prevEnd = curr[1];
            else
            {
                //Overlapping
                //We choose the one with lower end time
                prevEnd = Math.min(prevEnd,curr[1]);
                //deleting an interval so incr res
                res++;
            }
        }

        return res;

    }
}
