class Pair
{
    char ch;
    int count;

    Pair(char ch,int count)
    {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {

    //We need to maintain the consecutive freqmecy of a char not the overall frequency
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> stk = new Stack<>();

        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(stk.isEmpty() || stk.peek().ch != ch)
                stk.push(new Pair(ch,1));
            else
            {
                //Check if count matches k
                if(stk.peek().count + 1 == k)
                    stk.pop();
                else
                    stk.peek().count++; //Incr. count
            }
        }

        StringBuilder ans = new StringBuilder();

        for(Pair p : stk)
        {
            while(p.count > 0)
            {
                //Append char along with count
                ans.append(p.ch);
                p.count--;
            }
        }

        return ans.toString();
    }
}