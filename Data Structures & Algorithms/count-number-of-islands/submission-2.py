class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n,m = len(grid),len(grid[0])
        count = 0

        def dfs(i,j):
            if i < 0 or i == n or j < 0 or j == m or grid[i][j] == '0':
                return
            #Mark it as visited
            grid[i][j] = '0'
            #Check in all 4 direction
            dfs(i-1,j)
            dfs(i+1,j)
            dfs(i,j+1)
            dfs(i,j-1)

        for i in range(n):
            for j in range(m):
                #Start of the island
                if grid[i][j] == '1':
                    count += 1
                    dfs(i,j)

        return count