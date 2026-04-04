class Solution {

    public boolean isValid(String s) {
        
        Deque<Character> stk = new ArrayDeque<>();
        char[] str = s.toCharArray();
        
        for(char ch : str)
        {
            //Push the opposite pair in Stack.
            if(ch == '(')
                stk.push(')');
            else if(ch == '{')
                stk.push('}');
            else if(ch == '[')
                stk.push(']');
            else
            {
                //Meaning either we got the complement pair first 
                //or top of stack is not same as complement pair
                if(stk.isEmpty() || stk.peek() != ch)
                    return false;
                
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}
