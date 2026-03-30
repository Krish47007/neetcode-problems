class Solution {

    /*

        Perimiter is like border so whenever we go to a 
        cell that has water from island or go beyond the grid we return 1 as its border.
        Also once we visit an island if the next cell is also island we 
        dont consider it as border between the two, its a continuous part of the island.
        To mark the island cell that is already visited we mark it with 2 and we return 0 
        if we come here meaning its already visisted from some other cell.

    */

    private int rec(int i,int j,int n,int m, int[][] grid)
    {
        //Touching boundary so return 1
        if(i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0)
            return 1;
        
        //Already visited
        if(grid[i][j] == 2)
            return 0;

        grid[i][j] = 2;

        return 
            rec(i-1,j,n,m,grid) + 
            rec(i+1,j,n,m,grid) +
            rec(i,j-1,n,m,grid) +
            rec(i,j+1,n,m,grid);
    }

    public int islandPerimeter(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int perimeter = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    perimeter += rec(i,j,n,m,grid);
                }
            }
        }

        return perimeter;
    }
}