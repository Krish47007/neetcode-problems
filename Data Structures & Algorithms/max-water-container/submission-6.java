class Solution {
    public int maxArea(int[] heights) {

        int n = heights.length;
        int beg = 0, end = n-1;
        int maxArea = 0;

        while(beg < end)
        {
            int h = Math.min(heights[beg],heights[end]);
            int w = end - beg;
            int area = h * w;

            maxArea = Math.max(maxArea,area);

            if(heights[beg] <= heights[end])
                beg++;
            else
                end--;
        }

        return maxArea;
        
    }
}
