class Solution {

    private void dfs(int curr,int[] vis,List<List<Integer>> adj)
    {
        vis[curr] = 1;

        for(int conn : adj.get(curr))
        {
            if(vis[conn] == 0)
                dfs(conn,vis,adj);
        }
    }
    public int countComponents(int n, int[][] edges) {

        int[] vis = new int[n];
        int count = 0;
        //Construct adjacency list from edge list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        //Populate the list
        for(int i = 0;i<edges.length;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            //Add connections
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        for(int i = 0;i<n;i++)
        {
            if(vis[i] == 0)
            {
                count++;
                dfs(i,vis,adj);
            }
        }

        return count;
    }
}
