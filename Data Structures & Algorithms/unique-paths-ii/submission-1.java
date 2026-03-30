class Solution {

    private int rec(int i,int j,int n,int m,int[][] grid,int[][] dp)
    {
        if(i == n || j == m || grid[i][j] == 1)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        if(i == n-1 && j == m-1)
            return 1;

        int ans = rec(i+1,j,n,m,grid,dp) + rec(i,j+1,n,m,grid,dp);

        dp[i][j] = ans;

        return ans;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                dp[i][j] = -1;
            }
        }

        return rec(0,0,n,m,grid,dp);
    }
}