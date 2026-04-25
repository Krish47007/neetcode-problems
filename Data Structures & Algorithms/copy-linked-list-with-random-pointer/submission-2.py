"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        curr = head
        _map = {}
        while curr:
            temp = Node(curr.val)
            _map[curr] = temp
            curr = curr.next

        #Store null in map
        _map[None] = None
        #Create dummy nodes
        ans_head = Node(-1)
        ans_tail = ans_head
        curr = head

        while curr:
            #Take the node from map corresponding to curr node  
            temp = _map[curr]
            #Make the appropriate pointer changes
            temp.next = _map[curr.next]
            temp.random = _map[curr.random]
            ans_tail.next = temp
            ans_tail = ans_tail.next
            curr = curr.next
        
        return ans_head.next