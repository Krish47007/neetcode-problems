class Solution {
    public int findMin(int[] nums) {
        
        int beg = 0, end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while(beg <= end)
        {
            if(nums[beg] < nums[end])
            {
                ans = Math.min(ans,nums[beg]);
                break;
            }
            else
            {
                int mid = beg + (end - beg)/2;
                
                ans = Math.min(ans,nums[mid]);

                if(nums[mid] == nums[beg])
                {
                    //Can't determine which half to discard
                    //so increment beg.
                    beg++;
                }
                else if(nums[mid] > nums[beg])
                    beg = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return ans;
    }
}
