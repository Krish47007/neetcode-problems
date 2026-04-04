class Solution {
    public int[][] merge(int[][] intervals) {
        
        //Sort the intervals based on increasing order of start time
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        //Add first interval in res
        res.add(intervals[0]);
        
        for(int i = 1;i<n;i++)
        {
            //Check  next interval's start time and last intervals' end time 
            int[] last = res.get(res.size() - 1);
            if(intervals[i][0] <= last[1])
            {
                last[1] = Math.max(last[1],intervals[i][1]);
            }
            else
                res.add(intervals[i]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
