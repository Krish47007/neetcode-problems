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

        for(int i = 0;i<n;i++)
        {
            if(target >= mat[i][0] && target <= mat[i][m-1])
            {
                rowNum = i;
                break;
            }
        }
        return rowNum == -1 ? false : search(mat[rowNum],0,m-1,target);
    }
}
