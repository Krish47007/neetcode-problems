class Solution {
    public int maxArea(int[] heights) {

        int n = heights.length;
        int l = 0, r = n-1;
        int maxArea = 0;

        while( l < r)
        {
            int h = Math.min(heights[l],heights[r]);
            int w = r-l;
            int area = h * w;

            maxArea = Math.max(area,maxArea);

            //Move the smaller pillar
            if(heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
