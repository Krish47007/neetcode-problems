class Solution {

    private int rec(int i,int n,int sum,int[] nums,int[][] dp,int target)
    {
        if(i == n)
        {
            if(sum == target)
                return 1;
            else
                return 0;
        }

        if(dp[i][sum+1000] != -1)
            return dp[i][sum+1000];
        
        int plus = rec(i+1,n,sum + nums[i],nums,dp,target);
        int minus = rec(i+1,n,sum - nums[i],nums,dp,target);

        int ans = plus + minus;

        dp[i][sum + 1000] = ans;

        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n][2001];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<2001;j++)
            {
                dp[i][j] = -1;
            }
        }
        return rec(0,n,0,nums,dp,target);
        
    }
}
