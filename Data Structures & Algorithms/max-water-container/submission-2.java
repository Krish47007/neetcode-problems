class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;
        int l = 0, r = heights.length - 1;

        while(l < r)
        {
            int h = Math.min(heights[l],heights[r]);
            int w = r-l;
            int area = h * w;

            maxArea = Math.max(maxArea,area);

            if(heights[l] < heights[r])
                l++;
            else
                r--;
        }

        return maxArea;
    }
}
