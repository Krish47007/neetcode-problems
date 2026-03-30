class Solution {

    private int rec(int i,int n,int[] cost,int[] dp)
    {
        if(i >= n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int c1 = cost[i] + rec(i+1,n,cost,dp);
        int c2 = cost[i] + rec(i+2,n,cost,dp);

        int ans = Math.min(c1,c2);

        dp[i] = ans;

        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n];
    
        Arrays.fill(dp,-1);

        int c1 = rec(0,n,cost,dp);
        int c2 = rec(1,n,cost,dp);

        return Math.min(c1,c2);
    }
}
