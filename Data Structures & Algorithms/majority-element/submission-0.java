class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int me = nums[0], count = 1;

        for(int i = 1;i<n;i++)
        {
            //current element is same as me so incr. count
            if(nums[i] == me)
                count++;
            else
            {
                //Decrement count
                count--;
                //If its 0 then previous me is no longer a candidate for me
                //so reset count and make current element as me.
                if(count == 0)
                {
                    me = nums[i];
                    count = 1;
                }
            }
        }

        return me;
    }
}