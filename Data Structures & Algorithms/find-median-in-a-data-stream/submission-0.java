class MedianFinder {

    // Contains the smaller half of the input numbers
    private PriorityQueue<Integer> small;
    // Contains the larger half of the input numbers
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        
        //Max Heap
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        //Min Heap
        this.large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        //Add it in small heeap
        small.add(num);
        //If the larget element in max heap > smallest element in max heap
        // then move it.
        if(!large.isEmpty() && small.peek() > large.peek())
        {
            int temp = small.poll();
            large.add(temp);
        }

        //Check that the size of heaps at most differ by 1
        //If same do nothing else move it to the other heap
        if(small.size() - large.size() > 1)
        {
            large.add(small.poll());
        }
        else if(large.size() - small.size() > 1)
        {
            small.add(large.poll());
        }
        
    }
    
    public double findMedian() {

        double median = 0.0d;

        if(small.size() > large.size())
            median = small.peek();
        else if(large.size() > small.size())
            median = large.peek();
        else
        {
            median = (small.peek() + large.peek()) / (double)2;
        }

        return median;
        
    }
}
