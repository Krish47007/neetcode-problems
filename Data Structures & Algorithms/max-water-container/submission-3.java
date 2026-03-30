class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0, r = heights.length - 1;
        int ans = Integer.MIN_VALUE;
        while(l < r)
        {
            int h = Math.min(heights[l],heights[r]);
            int w = r-l;

            int area = h * w;
            ans = Math.max(ans,area);

            if(heights[l] < heights[r])
                l++;
            else
                r--;
        }

        return ans;
    }
}
