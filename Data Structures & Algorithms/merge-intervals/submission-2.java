class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        int n = intervals.length;
        int i = 1;

        while(i < n)
        {
            int[] prev = ans.get(ans.size() - 1);
            if(prev[1] >= intervals[i][0])
            {
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }
            else
                ans.add(intervals[i]);
            
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
