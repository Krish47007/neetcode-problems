class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        boolean[] exists = new boolean[n + 1];

        for (int i = 0;i<n;i++)
        {
            if(nums[i] >= 1 && nums[i] <= n)
                exists[nums[i]] = true;
        }

        for (int i = 1;i < n + 1;i++)
        {
            //First non true value is our ans
            if(!exists[i])
                return i;
        }
        //Array contains all n values so n+1 is the first missing +ve
        return n+1;

    }
}