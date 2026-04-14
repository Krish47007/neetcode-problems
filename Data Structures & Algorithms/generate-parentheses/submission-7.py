class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        open,closed = n,n

        def rec(open,closed,str):
            #Invalid state
            if open > closed:
                return
            #can get -ve
            if open < 0 or closed < 0:
                return
            #Exhausted all open and closed states
            if open == 0 and closed == 0:
                ans.append(str)
                return
            
            #Take open
            rec(open - 1,closed,str + "(")
            #Take closed
            rec(open,closed - 1,str+")")
        
        rec(n,n,"")
        return ans
    