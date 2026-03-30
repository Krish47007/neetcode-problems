class Solution {
    public int search(int[] nums, int target) {
        
        int beg = 0, end = nums.length - 1;

        while(beg <= end)
        {
            int mid = beg + (end - beg) / 2;

            if(nums[beg] <= nums[end])
            {
                //Sorted array
                
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] > target)
                    end = mid - 1;
                else
                    beg = mid + 1;
            }
            else
            {
                    if(nums[mid] == target)
                    return mid;

                if(nums[mid] >= nums[beg])
                {
                    //mid is in 1st sorted half
                    if(nums[beg] <= target && target < nums[mid])
                    {
                        end = mid - 1;
                    }
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

        return -1;

    }
}
