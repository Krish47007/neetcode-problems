class MinStack {

    private Stack<Integer> stk;
    private Stack<Integer> minStack;

    public MinStack() {
        
        this.stk = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        
        stk.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        
        if(stk.isEmpty())
            return;
        int temp = stk.pop();
        if( temp == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        
        return stk.peek();
    }
    
    public int getMin() {
    
       return minStack.peek();
    }
}
