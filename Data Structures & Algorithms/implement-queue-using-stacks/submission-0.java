class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    
    public void push(int x) {
        
        //Push always in Stack1
        s1.push(x);
    }
    
    public int pop() {
        
        if(!s2.isEmpty())
            return s2.pop();
        else if(!s1.isEmpty())
        {
            //Push all elements from s1 to s2.
            while(!s1.isEmpty())
                s2.push(s1.pop());
            return s2.pop();
        }
        else
            return -1;

    }
    
    public int peek() {
        
        if(!s2.isEmpty())
            return s2.peek();
        else if(!s1.isEmpty())
        {
            while(!s1.isEmpty())
                s2.push(s1.pop());
            
            return s2.peek();
        }
        else
            return -1;
    }
    
    public boolean empty() {
        
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */