class Solution {

    private Map<Character,Character> map = Map.of(')','(', '}','{',']','[');

    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        char[] str = s.toCharArray();

        for(char ch : str)
        {
            if(map.containsKey(ch))
            {
                if(stk.isEmpty() || stk.peek() != map.get(ch))
                    return false;
                //Valid so pop
                stk.pop();
            }
            else
                stk.push(ch);
        }

        return stk.isEmpty();
    }
}
