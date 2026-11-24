class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ans = ""
        n,m = len(word1),len(word2)
        i,j = 0,0
        """
        No extra flag is needed as in the loop,i and j never change except when it's their turn. Actually — check this: in the flag=True branch you only increment i, and in the flag=False branch you only increment j. So each iteration of the loop consumes exactly one char from each string. That means you could drop flag entirely and just do both appends in one iteration:
        """
        while i < n and j < m:
            ans += word1[i]
            ans += word2[j]
            i += 1
            j += 1
        #Add the leftover chars
        while i < n:
            ans += word1[i]
            i += 1
        while j < m:
            ans += word2[j]
            j += 1

        return ans