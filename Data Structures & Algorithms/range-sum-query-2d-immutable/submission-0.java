class NumMatrix {

    private int[][] prefSum;
    private int m;
    private int n;
    public NumMatrix(int[][] mat) {
        
        this.m = mat.length;
        this.n = mat[0].length;
        this.prefSum = new int[m][n];

        computeRowWisePrefixSum(mat,prefSum,m,n);
    }

    private void computeRowWisePrefixSum(int[][] mat,int[][] prefSum,int m,int n)
    {
        for(int i = 0;i<m;i++)
        {
            prefSum[i][0] = mat[i][0];
            for(int j = 1;j<n;j++)
            {
                prefSum[i][j] = prefSum[i][j-1] + mat[i][j];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        
        int sum = 0;

        for(int i = r1; i <= r2;i++)
        {
            if(c1 == 0)
                sum += prefSum[i][c2];
            else
                sum += prefSum[i][c2] - prefSum[i][c1-1];
        }

        return sum;


    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */