class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        
        //Count the frquency of each number
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        //Create a min-heap that holds only the k-most frequent element
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        map.forEach((num,freq) -> {

            pq.add(new int[]{num,freq});
            if(pq.size() > k)
                pq.poll();
        });

        int[] ans = new int[k];
        int idx = 0;

        while(!pq.isEmpty())
        {
            ans[idx++] = pq.poll()[0];
        }

        return ans;
    }
}
