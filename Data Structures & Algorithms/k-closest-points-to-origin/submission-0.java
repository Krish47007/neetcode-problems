class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> {

            int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
            int dist2 = p2[0] * p2[0] + p2[1] * p2[1];

            
            return Integer.compare(dist2,dist1);
        });

        for(int[] p : points)
        {
            pq.offer(p);

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