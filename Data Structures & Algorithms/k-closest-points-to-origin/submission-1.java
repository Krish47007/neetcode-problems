class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        //We need closest point so we need max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q) -> {

            int dist1 = p[0] * p[0] + p[1] * p[1];
            int dist2 = q[0] * q[0] + q[1] * q[1];

            return Integer.compare(dist2,dist1);
        });

        for(int[] p : points)
        {
            pq.add(p);
            //We want only k closest points
            if(pq.size() > k)
                pq.poll();
        }

        int[][] ans = new int[k][2];
        int idx = 0;

        while(!pq.isEmpty())
        {
            ans[idx++] = pq.poll();
        }

        return ans;
    }
}
