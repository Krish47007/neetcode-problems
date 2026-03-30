class Solution {

    private int dfs(int i,int j,int n,int m,int[][] grid)
    {
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0)
            return 1;
        
        if(grid[i][j] == 2)
            return 0;
            
        grid[i][j] = 2;

        return  dfs(i+1,j,n,m,grid) + 
                dfs(i-1,j,n,m,grid) +
                dfs(i,j+1,n,m,grid) +
                dfs(i,j-1,n,m,grid);
    }

    public int islandPerimeter(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int perimeter = 0;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    perimeter = dfs(i,j,n,m,grid);
                }
            }
        }

        return perimeter;
    }
}