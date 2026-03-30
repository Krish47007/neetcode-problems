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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((h1,h2) -> Integer.compare(h1.val,h2.val));

        ListNode dh = new ListNode(-1);
        ListNode dt = dh;

        for(ListNode head : lists)
        {
            if(head != null)
                pq.add(head);
        }
        while(!pq.isEmpty())
        {
            ListNode curr = pq.poll();
            dt.next = curr;
            dt = curr;
            if(curr.next != null)
                pq.add(curr.next);
        }

        return dh.next;
    }
}
