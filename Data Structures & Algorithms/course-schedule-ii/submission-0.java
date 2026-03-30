class Solution {

    public int[] findOrder(int n, int[][] preq) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < preq.length;i++)
        {
            int a = preq[i][0];
            int b = preq[i][1];

            // b -> a
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] res = new int[n];
        int k = 0;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            res[k++] = curr;
            for(int conn : adj.get(curr))
            {
                indegree[conn]--;
                if(indegree[conn] == 0)
                    q.add(conn);
            }
        }

        return k == n ? res : new int[]{};

    }
}

