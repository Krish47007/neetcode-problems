class Solution {

    private void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        //zp is the boundary of 0s
        //tp the boundary of 2s
        int zp = 0, tp = n-1;
        int i = 0;

        while(i <= tp)
        {
            if(nums[i] == 0)
            {
                swap(nums,zp,i);
                zp++;
              
            }
            else if(nums[i] == 2)
            {
                swap(nums,tp,i);
                tp--;
                i--;
                //i can't be increased as this swapped element could be 0
                // Example - [0,1,2,0,0]
            }
            //Increment i
            i++;
        }
    }
}