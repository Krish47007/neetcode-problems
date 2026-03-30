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
        /*
            If k == n then its as good as no rotation
            If k == n+1,n+2,n+3....
                    then its as good as k = 1,2,3,....
            So we take mod.
        */
         k = k % n;

        //Reverse the entire array
        reverse(nums,0,n-1);
        //Reverse k elements
        reverse(nums,0,k-1);
        //Reverse remaining elements
        reverse(nums,k,n-1);
    
        
    }
}