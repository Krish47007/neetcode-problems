class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        
        this.q = new LinkedList<>();
       
    }
    
    public void push(int x) {
        
        //Add it to second queue
        q.offer(x);
        
        //if there are n elements in queue then remove
        // n-1 elements from the front of the q and add at the back of the queue
        for(int i = q.size() - 1; i>0;i--)
        {
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        
        if(!q.isEmpty())
            return q.poll();
        
        return -1;
    }
    
    public int top() {
        
        if(!q.isEmpty())
            return q.peek();
        
        return -1;
    }
    
    public boolean empty() {
        
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */