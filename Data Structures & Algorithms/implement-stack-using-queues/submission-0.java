class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        
        //Add it to second queue
        q2.offer(x);
        //Copy all from first queue and put in second queue
        while(!q1.isEmpty())
            q2.offer(q1.poll());
        
        //Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        
        if(!q1.isEmpty())
            return q1.poll();
        
        return -1;
    }
    
    public int top() {
        
        if(!q1.isEmpty())
            return q1.peek();
        
        return -1;
    }
    
    public boolean empty() {
        
        return q1.isEmpty();
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