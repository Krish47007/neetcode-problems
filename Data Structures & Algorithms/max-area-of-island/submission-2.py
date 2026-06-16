class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        ans = 0

        def dfs(i,j):
            if i < 0 or i == n or j < 0 or j == m or grid[i][j] == 0:
                return
            #Consume the cell value
            grid[i][j] = 0
            #Increment the area value
            self.area += 1
            dfs(i-1,j)
            dfs(i+1,j)
            dfs(i,j-1)
            dfs(i,j+1)

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    #Reset the area as its start of a new island
                    self.area = 0
                    dfs(i,j)
                    ans = max(ans,self.area)
        
        return ans