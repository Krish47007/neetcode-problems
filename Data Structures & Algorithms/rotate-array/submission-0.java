class Solution {

    private void reverse(int[] arr,int beg,int end)
    {
        while(beg < end)
        {
            int temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
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