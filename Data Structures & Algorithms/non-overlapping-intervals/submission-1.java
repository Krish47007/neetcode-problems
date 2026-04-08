class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int n = intervals.length;

        if(n == 1)
            return 0;
        
        for(int i = 1;i < n;i++)
        {
            int[] prev = res.get(res.size() - 1);
            if(prev[1] > intervals[i][0])
            {
                if(prev[1] > intervals[i][1])
                {
                    res.remove(prev);
                    res.add(intervals[i]);
                }
                //else keep prev dont add curr

            }
            else
                res.add(intervals[i]);
        }

        return n - res.size();

    }
}
