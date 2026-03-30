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
        if(head == null)
            return null;
        
        ListNode slow = head;
        //Start fast from head.next so that we get the 
        //first node as mid node in case of even length LL
        ListNode fast = head.next;

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
        
        ListNode curr = head, prev = null;

        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    } 

    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
        
        //Mid of the LL
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        //Break the LL
        mid.next = null;

        //Reverse 2nd half
        ListNode revHead = reverse(newHead);

        ListNode curr1 = head, curr2 = revHead;

        while(curr1 != null && curr2 != null)
        {
            if(curr1.val != curr2.val)
                return false;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }
}