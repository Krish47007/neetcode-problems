class Solution {

    private boolean search(int[] nums,int beg,int end,int target)
    {
        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
            {
                end = mid - 1;

            }
            else
                beg = mid + 1;

        }

        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        
        int n = mat.length, m = mat[0].length;
        int rowNum = -1;
        int top = 0, bottom = n-1;

        while(top <= bottom)
        {
            int mid = top + (bottom - top)/2;
            if(target > mat[mid][m-1])
                top = mid + 1;
            else if( target < mat[mid][0])
                bottom = mid - 1;
            else
            {
                rowNum = mid;
                break;
            }
        }
        return rowNum == -1 ? false : search(mat[rowNum],0,m-1,target);
    }
}
