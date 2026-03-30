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
/*
        We need to use the concept of dummy node here and two pointers first and second.
        Initially both are standing at dummy. We will move first pointer by n+1.
        So before the sstart first and second pointer are at n distance.
        Now we will move both the first and second poiters by one until first reaches end.
        when iteration stops we remove second.next .
    */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy, second = dummy;

        //Move first pointer by n+1
        for(int i = 1;i<=n+1;i++)
            first = first.next;
        
        while(first != null)
        {
            first = first.next;
            second = second.next;
        }

        //Now second pointer is at nth node from end
        second.next = second.next.next;

        return dummy.next;
    }
}
