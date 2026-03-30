class Solution {

    private int rec(int n,int[] dp)
    {
        if( n < 0)
            return 0;
        if( n == 1 || n == 2)
            return n;
        if(dp[n] != -1)
            return dp[n];
        
        int ans = rec(n-1,dp) + rec(n-2,dp);

        dp[n] = ans;

        return ans;
    }
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return rec(n,dp);
        
    }
}
