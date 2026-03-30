class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length, l = 0, r = 0;
        int ans = n + 1;
        int sum = 0;

        while( r < n)
        {
            sum += nums[r];

            while( l<=r && sum >= target)
            {
                int len = r-l+1;
                ans = Math.min(ans,len);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return ans == n+1 ? 0 : ans;
        
    }
}