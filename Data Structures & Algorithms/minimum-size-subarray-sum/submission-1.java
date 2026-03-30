class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while( r < n)
        {
            sum += nums[r];

            while(l <= r && sum >= target)
            {
                int len = r-l+1;
                ans = Math.min(ans,len);
                //shrink window
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}