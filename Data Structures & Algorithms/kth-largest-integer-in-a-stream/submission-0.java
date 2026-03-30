class KthLargest {

    private PriorityQueue<Integer> pq;
    private int heapSize;
    public KthLargest(int k, int[] nums) {
        
        this.pq = new PriorityQueue<>();
        this.heapSize = k;
        buildHeap(pq,nums);     
    }

    private void buildHeap(PriorityQueue<Integer> pq,int[] nums)
    {
        for(int n : nums)
        {
            pq.offer(n);

            if(pq.size() > heapSize)
                pq.poll();
        }
    }
    
    public int add(int val) {

        this.pq.offer(val);

        if(this.pq.size() > heapSize)
            pq.poll();
        
        return this.pq.peek();
        
    }
}
