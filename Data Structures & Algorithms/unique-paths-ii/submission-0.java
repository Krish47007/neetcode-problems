class Solution {

    private int rec(int i,int j,int n,int m,int[][] dp,int[][] grid)
    {
        if(i == n || j == m || grid[i][j] == 1)
            return 0;

        if(i == n-1 && j == m-1)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        int down = rec(i+1,j,n,m,dp,grid);
        int right = rec(i,j+1,n,m,dp,grid);

        int ans = down + right;

        dp[i][j] = ans;

        return ans;
    }
    public int uniquePathsWithObstacles(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                dp[i][j] = -1;
            }
        }

        return rec(0,0,n,m,dp,grid);
    }
}