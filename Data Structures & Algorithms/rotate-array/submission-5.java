class Solution {

    private void reverse(int[] nums,int beg,int end)
    {
        while(beg < end)
        {
            int temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;

            beg++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}