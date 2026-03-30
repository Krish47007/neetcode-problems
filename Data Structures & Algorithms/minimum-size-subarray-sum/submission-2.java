class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int l = 0, r = 0;
        int maxLen = Integer.MAX_VALUE;
        int sum = 0;

        while(r < n)
        {
            sum += nums[r];

            while(l <= r && sum >= target)
            {
                int len = r-l+1;
                maxLen = Math.min(maxLen,len);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}