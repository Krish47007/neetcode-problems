/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head1;
        while(curr != null)
        {
           set.add(curr);
           curr = curr.next;
        }

        curr = head2;

        while(curr != null)
        {
            if(!set.add(curr))
                return curr;
            
            curr = curr.next;
        }

        return null;
    }
}