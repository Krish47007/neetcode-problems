class Solution {

    private int rec(int i,int j,int n,int m,int[][] dp)
    {
        if(i == n || j == m)
            return 0;
        if(i == n-1 && j == m-1)
            return 1;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int down = rec(i+1,j,n,m,dp);
        int right = rec(i,j+1,n,m,dp);

        int ans = down + right;

        dp[i][j] = ans;
        return ans;
    }
    public int uniquePaths(int n, int m) {
        
        int[][] dp = new int[n][m];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                dp[i][j] = -1;
            }
        }

        return rec(0,0,n,m,dp);
    }
}
