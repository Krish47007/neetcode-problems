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
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        //Start from the 1st house and go till n-1th house
        int way1 = nums[0] + rec(2,n-1,nums,dp1);
        //Start from the 2nd house and go till nth house
        int way2 = rec(1,n,nums,dp2);

        return Math.max(way1,way2);
        
    }
}
