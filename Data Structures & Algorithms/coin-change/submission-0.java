class Solution {

    private int rec(int i,int n,int amount,int[] coins,int[][] dp)
    {
        if(amount < 0)
            return Integer.MAX_VALUE;

        if(i == n)
        {
            if(amount == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        if(amount == 0)
            return 0;
        
        if(dp[i][amount] != -1)
            return dp[i][amount];
        
        int take = rec(i,n,amount - coins[i],coins,dp);
        if(take != Integer.MAX_VALUE)
            take += 1;
            
        int skip = rec(i+1,n,amount,coins,dp);

        int ans = Math.min(skip,take);
        
        dp[i][amount] = ans;

        return ans;
    }
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<=amount;j++)
            {
                dp[i][j] = -1;
            }
        }

        int ans =  rec(0,n,amount,coins,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}
