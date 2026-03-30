class Solution {
    public int findMin(int[] nums) {
        
        int beg = 0, end = nums.length - 1;
        int minVal = Integer.MAX_VALUE;

        while(beg <= end)
        {
            if(nums[beg] <= nums[end])
            {
                //The part of the array is sorted so the first element could be 
                // the minimum element
                minVal = Math.min(minVal,nums[beg]);
                break;
            }

            int mid = beg + (end - beg)/2;

            //Take the mid as minVal
            minVal = Math.min(minVal,nums[mid]);

            //If our mid element is part of left sorted half
            if(nums[mid] >= nums[beg])
                beg = mid + 1;
            else
            //If our mid element is part of right sorted half
                end = mid - 1;
        }

        return minVal;
    }
}
