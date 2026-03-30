class Solution {

    /*
    We always need to repeatedly remove the two heaviest stones.
    A max-heap is perfect for this because it lets us efficiently extract the largest values.
    */
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int s : stones)
        {
            pq.add(s);
        }

        while(pq.size() > 1)
        {
            int s1 = pq.poll();
            int s2 = pq.poll();
            //If both are of same weight the get destroyed
            // if not then left over is pushed in heap
            if( s1 != s2)
            {
                pq.add(Math.abs(s1-s2));
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
        
    }
}
