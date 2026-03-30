class Solution {

    /*
            [3,2,4]         beg = 0, 
                            end = 2, mid = 1
        [3,2]       [4]
    */

    private void merge(int[] nums,int beg, int mid, int end)
    {
        int n = mid - beg + 1;
        int m = end - mid;

        int[] leftArray = new int[n];
        int[] rightArray = new int[m];

        //Copy 1st half in temp array
        for(int i = 0;i<n;i++)
        {
            //1st half can start from any point as part of recursion 
            //so we cant always start from 0.
            leftArray[i] = nums[beg + i];
        }
        //Copy 2nd half in temp array
        for(int j = 0;j<m;j++)
        {
            //2nd half starts from mid + 1
            rightArray[j] = nums[mid + 1 + j];
        }

        //Merge two sorted halves into the original array
        int i = 0, j = 0, k = beg;

        while(i < n && j < m)
        {
            // = ensures the stability is maintained
            if(leftArray[i] <= rightArray[j])
            {
                nums[k] = leftArray[i];
                i++;
            }
            else
            {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }
        //Copy left over elements
        while(i < n)
        {
            nums[k] = leftArray[i];
            k++;
            i++;
        }
        while(j < m)
        {
            nums[k] = rightArray[j];
            k++;
            j++;
        }
    }
    private void mergeSort(int[] nums,int beg,int end)
    {
        if( beg < end)
        {
            int mid = beg + (end - beg)/2;

            //call on 1st half
            mergeSort(nums,beg,mid);
            //call on 2nd half
            mergeSort(nums,mid + 1,end);

            //Merge two sorted halves
            merge(nums,beg,mid,end);
        }
    }
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums,0,nums.length - 1);
        return nums;
    }
}