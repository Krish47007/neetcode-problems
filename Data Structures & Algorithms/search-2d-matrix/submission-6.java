class Solution {

    private boolean search(int[] nums,int beg,int end,int target)
    {
        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                beg = mid + 1;
        }

        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        
        int n = mat.length;
        int m = mat[0].length;
        //We apply binary search on the matrix to find which row may have the target value
        int top = 0, bottom = n-1;
        int row = -1;
        while(top <= bottom)
        {
            int mid = top + (bottom - top)/2;
            //If the target value is larger than the last value in the row
            // then we need to search next rows
            if( target > mat[mid][m-1])
                top = mid + 1;
            else if(target < mat[mid][0] ) //search rows above
                bottom = mid - 1;
            else
            {
                //We got row where target may exist.
                row = mid;
                break;
            }
        }

        //If target is smaller than the first element in the matrix or larger than
        //the last element of the matrix
        if(row == -1)
            return false;
            
        return search(mat[row],0,m-1,target);
    }
}
