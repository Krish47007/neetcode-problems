class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = 0, fast = 0;
        //Slow moves by 1 step and afst moves by 2 steps.
        while(true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            //There's duplcation hence the cycle
            if(slow == fast)
                break;
        }

        int curr = 0;

        while(true)
        {
            curr = nums[curr];
            slow = nums[slow];
            //Point of cycle is the element that is duplicate.
            if(slow == curr)
                break;
        }

        return curr;
    }
}
