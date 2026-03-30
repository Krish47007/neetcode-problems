class Solution {

    private int rec(int i,int n,int buyStatus,int[] prices,int[][] dp)
    {
        if(i == n)
            return 0;
        
        if(dp[i][buyStatus] != -1)
            return dp[i][buyStatus];
        
        int ans = 0;
        if(buyStatus == 0)
        {
            int buy = -prices[i] + rec(i+1,n,1,prices,dp);
            int skip = rec(i+1,n,0,prices,dp);

            ans = Math.max(buy,skip);
        }
        else
        {
            int sell = prices[i] + rec(i+1,n,0,prices,dp);
            int skip = rec(i+1,n,1,prices,dp);

            ans = Math.max(sell,skip);
        }

        dp[i][buyStatus] = ans;

        return ans;
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int k = 2;
        int[][] dp = new int[n][k];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<k;j++)
            {
                dp[i][j] = -1;
            }
        }

        return rec(0,n,0,prices,dp);
        
    }
}