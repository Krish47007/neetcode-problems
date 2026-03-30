class Solution {

    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0, r = 0;
        int zc = 0, ans = 0;

        while(r < n)
        {
            if(nums[r] == 0)
                zc++;
            
            while(l <= r && zc > k)
            {
                if(nums[l] == 0)
                    zc--;
                l++;
            }
            int count = r-l+1;
            ans = Math.max(count,ans);
            r++;
        }

        return ans;
    }
}