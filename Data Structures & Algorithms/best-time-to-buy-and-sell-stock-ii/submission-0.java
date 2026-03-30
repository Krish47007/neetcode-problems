class Solution {

    private int rec(int i,int n,int buyStatus,int[][] dp,int[] prices)
    {
        if( i == n)
            return 0;

        if(dp[i][buyStatus] != -1)
            return dp[i][buyStatus];
        
        int ans = 0;

        if(buyStatus == 0)
        {
            //Buy
            int buy = rec(i+1,n,1,dp,prices) - prices[i];
            //Dont buy
            int skip = rec(i+1,n,0,dp,prices);

            ans = Math.max(buy,skip);
        }
        else
        {
            //Sell
            int sell = prices[i] + rec(i+1,n,0,dp,prices);
            //Hold
            int hold = rec(i+1,n,1,dp,prices);

            ans = Math.max(sell,hold);
        }

        dp[i][buyStatus] = ans;
        return ans;
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];
        int buyStatus = 0;

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<2;j++)
            {
                dp[i][j] = -1;
            }
        }

        return rec(0,n,buyStatus,dp,prices);
        
    }
}