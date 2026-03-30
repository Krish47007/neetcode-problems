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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode leftPrev = dummy, curr = head;
        //Point leftPrev to the node before left
        for(int i = 0; i<left - 1;i++)
        {
            leftPrev = curr;
            curr = curr.next;
        }
        //Now curr is pointing to left node
        //Reverse nodes
        ListNode prev = null;
        for(int i = 0;i < right-left+1;i++)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //curr now points to node after right
        //Make leftPrev'next point to curr
        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;
    }
}