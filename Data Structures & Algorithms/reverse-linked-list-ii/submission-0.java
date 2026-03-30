/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode reverse(ListNode start,ListNode end,ListNode nextNode)
    {
        ListNode prev = nextNode;
        ListNode curr = start;
        ListNode endOfList = end.next;
        while(curr != endOfList)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right)
            return head;
        
        ListNode prevNode = null, nextNode = null;
        ListNode curr = head;
        int pos = 0;
        ListNode start = null, end = null;

        while(curr != null)
        {
            pos++;
            if(pos == left)
            {
                start = curr;
            }
            else if(pos < left)
                prevNode = curr;
            
            if(pos == right)
            {
                end = curr;
                nextNode = curr.next;
                break;
            }
            curr = curr.next;
        }

        ListNode revHead = reverse(start,end,nextNode);
        if(prevNode != null)
        {
            prevNode.next = revHead;
            return head;
        }
        else
            return revHead;

       
    }
}