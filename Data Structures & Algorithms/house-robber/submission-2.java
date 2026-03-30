class Solution {

    private int rec(int i,int n,int[] nums,int[] dp)
    {
        if(i >= n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        
        int steal = nums[i] + rec(i+2,n,nums,dp);
        int skip = rec(i+1,n,nums,dp);

        int ans = Math.max(steal,skip);

        dp[i] = ans;

        return ans;
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(0,n,nums,dp);
    }
}
