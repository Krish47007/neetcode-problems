class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        n = len(fruits)
        _map = {}
        l,r = 0,0
        ans = 0

        while r < n:
            _map[fruits[r]] = _map.get(fruits[r],0) + 1
            #CHeck if the basket has more than 2 types of fruits
            while l <= r and len(_map) > 2:
                _map[fruits[l]] -= 1
                if _map[fruits[l]] == 0:
                    _map.pop(fruits[l])
                l += 1
            
            ans = max(ans,r-l+1)
            r += 1
        
        return ans
