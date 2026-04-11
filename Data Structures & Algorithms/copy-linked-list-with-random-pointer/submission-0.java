/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null)
            return null;
        Map<Node,Node> map = new HashMap<>();

        Node curr = head;

        while(curr != null)
        {
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        map.put(null,null);

        Node ansHead = new Node(-1);
        Node ansTail = ansHead;
        curr = head;
        while(curr != null)
        {
            Node temp = map.get(curr);
            ansTail.next = temp;
            ansTail = ansTail.next;
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);

            curr = curr.next;
        } 

        return ansHead.next;
    }
}
