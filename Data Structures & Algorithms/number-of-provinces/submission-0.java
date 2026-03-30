class Solution {

    private void rec(int curr,int n,int[] vis,int[][] isConnected)
    {
        vis[curr] = 1;

        for(int conn = 0;conn < isConnected[curr].length;conn++)
        {
            if(vis[conn] == 0 && isConnected[curr][conn] == 1)
                rec(conn,n,vis,isConnected);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int[] vis = new int[n];

        int count = 0;

        for(int i = 0;i<n;i++)
        {
            //Start of a province
            if(vis[i] == 0)
            {
                count++;
                rec(i,n,vis,isConnected);
            }
        }

        return count;
    }
}