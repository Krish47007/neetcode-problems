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

        for(int i = 0;i < n;i++)
        {
            if(mat[i][0] <= target && mat[i][m-1] >= target)
                return search(mat[i],0,m-1,target);
        }

        return false;
    }
}
