class Solution {
    public boolean search(int[] nums, int target) {
        
        int beg = 0, end = nums.length - 1;

        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(nums[mid] == target)
            {
                return true;
            }
            if(nums[beg] < nums[mid])
            {
                //left sorted half
                if(target >= nums[beg] && target < nums[mid])
                    end = mid - 1;
                else
                    beg = mid + 1;             
            }
            else if(nums[beg] > nums[mid])
            {
                //Right sorted half
                if(target > nums[mid] && target <= nums[end])
                    beg = mid + 1;
                else
                    end = mid - 1;
            }
            else
            {
                //nums[mid] and nums[beg] are same so can't discard any half surely
                //We know if nums[mid] is not equal to target then nums[beg] is also not equal to target
                //so best thing we can do is increment beg linearly
                beg++;
            }
        }
        return false;
    }
}
