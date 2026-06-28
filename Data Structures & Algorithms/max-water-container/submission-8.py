class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        l,r = 0,n-1
        maxArea = 0

        while l < r:
            h = min(heights[l],heights[r])
            w = r-l
            area = h * w
            maxArea = max(area,maxArea)
            #Always move the smaller pillar
            if heights[l] <= heights[r]:
                l += 1
            else:
                r -= 1
        return maxArea