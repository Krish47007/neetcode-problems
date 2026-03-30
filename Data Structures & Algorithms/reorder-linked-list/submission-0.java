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

    private ListNode findMid(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head,prev = null;

        while(curr != null)
        {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        
        ListNode mid = findMid(head);
        ListNode nextNode = mid.next;
        //break the list
        mid.next = null;

        ListNode revHead = reverse(nextNode);

        ListNode curr1 = head, curr2 = revHead;

        while(curr1 != null && curr2 != null)
        {
            ListNode n1 = curr1.next;
            ListNode n2 = curr2.next;

            curr1.next = curr2;
            curr2.next = n1;
            curr1 = n1;
            curr2 = n2;
        }

        
    }
}
