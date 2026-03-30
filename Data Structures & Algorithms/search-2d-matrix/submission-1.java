class Solution {

    private boolean exists(int[][] mat,int row,int beg,int end,int target)
    {
        while(beg <= end)
        {
            int mid = beg + (end - beg)/2;
            if(mat[row][mid] == target)
                return true;
            else if(mat[row][mid] > target)
                end = mid - 1;
            else
                beg = mid + 1;
        }

        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        
        int n = mat.length, m = mat[0].length;

        for(int i = 0;i<n;i++)
        {
            if(target >= mat[i][0] && target <= mat[i][m-1])
            {
                if(exists(mat,i,0,m-1,target))
                    return true;
            }
        }

        return false;
    }
}
