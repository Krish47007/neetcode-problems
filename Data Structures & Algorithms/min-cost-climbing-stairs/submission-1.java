class Solution {

    private int rec(int i,int n,int[] cost,int[] dp)
    {
        // i can go beyond n
        if(i >= n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        //We can either take one step or two steps
        //Pay the cost for the step
        int c1 = cost[i] + rec(i+1,n,cost,dp);
        int c2 = cost[i] + rec(i+2,n,cost,dp);

        //Take min of these two choices
        int ans = Math.min(c1,c2);

        dp[i] = ans;

        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n];
    
        Arrays.fill(dp,-1);

        //We can either start from 0th step or 1st step
        //We need to take the minimum of these two.
        int c1 = rec(0,n,cost,dp);
        int c2 = rec(1,n,cost,dp);

        return Math.min(c1,c2);
    }
}
