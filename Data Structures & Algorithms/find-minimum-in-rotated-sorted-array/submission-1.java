class Solution {
    public int findMin(int[] nums) {
        
        int beg = 0, end = nums.length - 1;
        int minElement = Integer.MAX_VALUE;

        while(beg <= end)
        {
            if(nums[beg] <= nums[end])
            {
                //Array is sorted but not rotated
                minElement = Math.min(nums[beg],minElement);
                break;
            }
            else
            {
                //Check mid
                int mid = beg + (end - beg)/2;
                minElement = Math.min(minElement,nums[mid]);

                //Check where mid lies
                if(nums[mid] >= nums[beg])
                {
                    //Mid is in left sorted half
                    beg = mid + 1;
                }
                else
                    end = mid - 1;
            }
        }

        return minElement;
    }
}
