class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;
        int zc = 0;
        int l = 0, r = 0;
        int ans = 0;

        while(r < n)
        {
            if(nums[r] == 0)
                zc++;
            
            while( l < r && zc > 1)
            {
                if(nums[l] == 0)
                    zc--;
                l++;
            }

            ans = Math.max(ans,r-l+1);
            r++;
        }

        return ans;
    }
}
