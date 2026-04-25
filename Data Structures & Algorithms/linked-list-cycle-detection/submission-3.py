# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        fast = slow = head

        while fast and fast.next:
            fast = fast.next.next #Move fast by two nodes
            slow = slow.next      #Move slow by one
            #If fast and slow meet then its a cycle
            if fast == slow:
                return True
        
        return False