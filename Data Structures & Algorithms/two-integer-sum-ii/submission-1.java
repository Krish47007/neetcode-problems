class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans = new int[2];
        int beg = 0, end = nums.length - 1;

        while(beg < end)
        {
            int sum = nums[beg] + nums[end];
            if(sum == target)
            {
                ans[0] = beg + 1;
                ans[1] = end + 1;
                break;
            }
            else if(sum > target)
                end--;
            else
                beg++;
        }

        return ans;
    }
}
