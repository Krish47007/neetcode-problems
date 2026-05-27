class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n,m = len(grid),len(grid[0])
        maxArea = 0

        def dfs(i,j):
            if i < 0 or i == n or j < 0 or j == m or grid[i][j] == 0:
                return 0
            #Consume the cell
            grid[i][j] = 0
            #Check in all 4 directions
            up = dfs(i-1,j)
            down = dfs(i+1,j)
            left = dfs(i,j-1)
            right = dfs(i,j+1)
            #return the total area, 1 is for current cell
            return 1 + up + down + left + right

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    area = dfs(i,j)
                    maxArea = max(maxArea,area)
        
        return maxArea