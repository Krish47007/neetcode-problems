class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int me = 0, count = 0;

        for(int i = 0;i<n;i++)
        {
            //count is 0 then set current element as me
            if(count == 0)
            {
                me = nums[i];
                count = 1;
            }
            else
            {
                //Check if curr element same as me then incr. count else decr.
                if(me == nums[i])
                    count++;
                else
                    count--;
            }
        }

        return me;
    }
}