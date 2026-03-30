class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        this.large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        small.add(num);

        if(!large.isEmpty() && small.peek() > large.peek())
        {
            large.add(small.poll());
        }

        if(Math.abs(small.size() - large.size()) > 1)
        {
            if(small.size() > large.size())
                large.add(small.poll());
            else
                small.add(large.poll());
        }
        
    }
    
    public double findMedian() {
        
        if(small.size() > large.size())
            return small.peek();
        else if(large.size() > small.size())
            return large.peek();
        else
        {
            double avg = (small.peek() + (double)large.peek()) / 2;
            return avg;
        }
    }
}
