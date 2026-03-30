class Solution {

    private void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int zp = -1, tp = n;

        for(int i = 0;i<tp;i++)
        {
            if(nums[i] == 0)
            {
                ++zp;
                swap(nums,zp,i);
                
            }
            if(nums[i] == 2)
            {
                --tp;
                swap(nums,tp,i);
                i--;
            }
        }

       // return nums;
    }
}