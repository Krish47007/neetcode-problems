class Solution {
    
    private void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {

        int n = nums.length;
        //l is the boundary of 0s
        //r the boundary of 2s
        int l = 0, r = n-1;
        int i = 0;

        //We only need to go till r as r is the boundary for 2 so beyond are all elements are 2
        //so no need to check them.
        while(i <= r)
        {
            if(nums[i] == 0)
            {
                swap(nums,l,i);
                //Increment both i and l
                l++;
            }
            else if(nums[i] == 2)
            {
                swap(nums,r,i);
                r--;
                i--;
                // i can't be increased as this swapped element could be 0
                // Example - [0,1,2,0,0]
            }
            //In case of 1s just increment
            i++;
        }
    }

}