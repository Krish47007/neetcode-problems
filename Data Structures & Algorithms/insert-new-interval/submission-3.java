class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while( i < n && intervals[i][1] < newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }

        while( i < n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }

        //insert new interval
        ans.add(newInterval);

        //Add leftover
        while(i < n)
            ans.add(intervals[i++]);
        
        return ans.toArray(new int[ans.size()][]);
    }
}
