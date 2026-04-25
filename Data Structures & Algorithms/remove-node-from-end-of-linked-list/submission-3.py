# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        first,second = dummy,dummy
        #Move first node by n+1
        for i in range(1,n+2):
            first = first.next
        
        #Move both the pointers by 1
        while first:
            first = first.next
            second = second.next

        #second is at (n+1)th node from end
        second.next = second.next.next

        return dummy.next