class NumMatrix {

    private int[][] prefSum;
    private int m;
    private int n;
    public NumMatrix(int[][] mat) {
        
        this.m = mat.length;
        this.n = mat[0].length;
        this.prefSum = new int[m+1][n+1];

        computeMatPrefixSum(mat,prefSum,m,n);
    }

    private void computeMatPrefixSum(int[][] mat,int[][] prefSum,int m,int n)
    {
        for(int i = 0;i<m;i++)
        {
            int prefix = 0;
            for(int j = 0;j<n;j++)
            {
                prefix += mat[i][j];
                int above = prefSum[i][j+1];
                prefSum[i+1][j+1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        

        int bottomRight = prefSum[r2 + 1][c2 +1];
        int above = prefSum[r1][c2 + 1];
        int left = prefSum[r2 + 1][c1];
        int topLeft = prefSum[r1][c1];

        return bottomRight - above - left + topLeft;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */