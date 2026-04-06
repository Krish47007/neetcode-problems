class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int maxLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;

        while( r < n)
        {
            sum += nums[r];

            while( l <= r && sum >= target)
            {
                int len = r - l + 1;
                maxLen = Math.min(len,maxLen);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}