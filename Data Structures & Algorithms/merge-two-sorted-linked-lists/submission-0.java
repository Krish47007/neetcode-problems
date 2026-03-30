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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode curr1 = head1, curr2 = head2;
        ListNode ansHead = new ListNode(-1);
        ListNode ansTail = ansHead;

        while(curr1 != null && curr2 != null)
        {
            ListNode temp = null;
            if(curr1.val <= curr2.val)
            {    
                temp = new ListNode(curr1.val);
                curr1 = curr1.next;
            }
            else{
                temp = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
                
            ansTail.next = temp;
            ansTail = temp;
            
        }

        while(curr1 != null)
        {
            ListNode temp = new ListNode(curr1.val);
            ansTail.next = temp;
            ansTail = temp;
            curr1 = curr1.next;
        }

        while(curr2 != null)
        {
            ListNode temp = new ListNode(curr2.val);
            ansTail.next = temp;
            ansTail = temp;
            curr2 = curr2.next;
        }

        return ansHead.next;
        
    }
}