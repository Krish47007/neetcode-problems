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
            if(curr1.val <= curr2.val)
            {    
                //Select from List1
                ansTail.next = curr1;
                curr1 = curr1.next;
            }
            else{
                //Select from list2
                ansTail.next = curr2;
                curr2 = curr2.next;
            }

            //Adjust ansTail    
            ansTail = ansTail.next;
            
        }

        //If anything left in list1
        while(curr1 != null)
        {      
            ansTail.next = curr1;
            ansTail = ansTail.next;
            curr1 = curr1.next;
        }
        //If anything left in list2
        while(curr2 != null)
        {      
            ansTail.next = curr2;
            ansTail = ansTail.next;
            curr2 = curr2.next;
        }

        return ansHead.next;
        
    }
}