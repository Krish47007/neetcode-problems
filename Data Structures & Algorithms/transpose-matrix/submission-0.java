class Solution {
    public int[][] transpose(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[m][n];

        for(int i = 0;i<m;i++)
        {
            
            for(int j = 0;j<n;j++)
            {
                ans[i][j] = mat[j][i];
            }
        }

        return ans;
    }
}