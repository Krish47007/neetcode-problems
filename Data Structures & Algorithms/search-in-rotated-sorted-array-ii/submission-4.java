class Solution {
    public boolean search(int[] nums, int target) {
        
        int beg = 0, end = nums.length - 1;

        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(nums[mid] == target)
                return true;
            // Array is sorted and not rotated
            //so perform normal binary search
            if(nums[beg] < nums[end])
            {
                if(nums[mid] > target)
                    end = mid - 1;
                else
                    beg = mid + 1;
            }
            else
            {
                if(nums[beg] == nums[mid])
                {
                    //Can't decide which side to go so incr beg linearly
                    beg++;
                }
                else if(nums[beg] < nums[mid])
                {
                    //We are in left sorted half
                    if(target >= nums[beg] && target < nums[mid])
                        end = mid - 1;
                    else
                        beg = mid + 1;
                }
                else
                {
                    //we are in right sorted half
                    if(target > nums[mid] && target <= nums[end])
                        beg = mid + 1;
                    else
                        end = mid - 1;
                }
                
            }
            
        }
        return false;
    }
}