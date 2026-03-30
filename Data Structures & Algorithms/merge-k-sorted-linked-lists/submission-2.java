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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new 
                            PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        
        for(ListNode head : lists)
        {
            if(head != null)
                pq.add(head);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;

        while(!pq.isEmpty())
        {
            ListNode curr = pq.poll();
            dummyTail.next = curr;
            dummyTail = curr;
            if(curr.next != null)
                pq.add(curr.next);
        }

        return dummyHead.next;
    }
}
