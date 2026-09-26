class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #If the lengths are not same they can't be anagrams
        if len(s) != len(t):
            return False
        _map = {}
        #Put all chars of first string in map
        for ch in s:
            _map[ch] = _map.get(ch,0) + 1
        #Using chars from second string try to empty the map
        for ch in t:
            if ch in _map:
                _map[ch] = _map.get(ch) - 1
                if _map[ch] == 0:
                    _map.pop(ch)
        #If the map is empty then its anagram            
        return len(_map) == 0