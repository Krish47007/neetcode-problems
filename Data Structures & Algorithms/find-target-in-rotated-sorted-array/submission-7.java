class Solution {
    public int search(int[] nums, int target) {
        
        int beg = 0, end = nums.length - 1;
        int ans = -1;

        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(nums[mid] == target)
            {
                ans = mid;
                break;
            }
            if(nums[beg] < nums[end])
            {
                
                if(nums[mid] > target)
                    end = mid - 1;
                else
                    beg = mid + 1;
            }
            else
            {
                if(nums[mid] >= nums[beg])
                {
                    if(target >= nums[beg] && target < nums[mid])
                        end = mid - 1;
                    else
                        beg = mid + 1;
                }
                else
                {
                    if(target > nums[mid] && target <= nums[end])
                        beg = mid + 1;
                    else
                        end = mid - 1;
                }
            }
        }
        return ans;
    }
}
