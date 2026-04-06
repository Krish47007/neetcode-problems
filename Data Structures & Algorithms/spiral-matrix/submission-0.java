class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        
        List<Integer> ans = new ArrayList<>();
        int n = mat.length, m = mat[0].length;

        int left = 0, top = 0;
        int right = m, bottom = n;

        while(left < right && top < bottom)
        {
            //Traverse top row
            for(int i = left;i < right;i++)
                ans.add(mat[top][i]);
            
            top++; //top row is visited so increment

            //Traverse right column
            for(int i = top; i < bottom;i++)
                ans.add(mat[i][right - 1]);
            
            right--; //right column is done so decrement right

            //If its a row matrix or column matrix
            if(!(left < right && top < bottom))
                break;
            
            for(int i = right - 1; i >= left; i--)
                ans.add(mat[bottom - 1][i]);
            bottom--;

            for(int i = bottom - 1; i >= top; i--)
                ans.add(mat[i][left]);
            left++;
        }

        return ans;
    }
}
