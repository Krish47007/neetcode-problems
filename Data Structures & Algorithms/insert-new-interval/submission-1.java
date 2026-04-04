class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        //Put all the intervals whose end time < start time of new interval in res
        while(i < n && intervals[i][1] < newInterval[0])
        {
            res.add(intervals[i]);
            i++;
        }

        //If overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1])
        {
            //update start time
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            //update end time
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);

            i++;

        }

        //Now we have the exact position where newInterval should go
        res.add(newInterval);

        //Check if any intervals are left
        while( i < n)
        {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
