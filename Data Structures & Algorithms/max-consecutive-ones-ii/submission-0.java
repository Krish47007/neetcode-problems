class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int zc = 0;
        int n = nums.length;
        int l = 0, r = 0;
        int ans = 0;

        while(r < n)
        {
            if(nums[r] == 0)
                zc++;
            
            while(l < r && zc > 1)
            {
                if(nums[l] == 0)
                    zc--;
                l++;
            }
            int len = r-l+1;
            ans = Math.max(ans,len);
            r++;
        }

        return ans;
    }
}
