class Solution {

    private int rec(int i,int n,int sum,int[] nums,int target,int[][] dp,int offSet)
    {
        if(i == n)
        {
            if(sum == target)
                return 1;
            else
                return 0;
        }

        if(dp[i][sum + offSet] != -1)
            return dp[i][sum + offSet];
        
        int c1 = rec(i+1,n,sum + nums[i],nums,target,dp,offSet);
        int c2 = rec(i+1,n,sum - nums[i],nums,target,dp,offSet);

        int ans = c1 + c2;

        dp[i][sum + offSet] = ans;

        return ans;
    }
            
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        
        int totalSum = 0;
        for(int x : nums)
            totalSum += x;

        int offSet = totalSum;
        int[][] dp = new int[n][2 * totalSum + 1];

        for(int i = 0;i<n;i++)
        {
            for(int j = 0; j< 2 * totalSum + 1;j++)
            {
                dp[i][j] = -1;
            }
        }

        return rec(0,n,0,nums,target,dp,offSet);
    }
}
