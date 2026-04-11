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
        
        //Stores curr node and a corresponding new node
        Map<Node,Node> map = new HashMap<>();

        Node curr = head;

        while(curr != null)
        {
            //create a new node and put it to map corresponding to new node
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        //Map null as well
        map.put(null,null);

        Node ansHead = new Node(-1);
        Node ansTail = ansHead;
        curr = head;
        while(curr != null)
        {
            //Get the node corresponding to curr node
            Node temp = map.get(curr);
            ansTail.next = temp;
            ansTail = ansTail.next;
            //Map the next and random pointers accordingly
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);

            curr = curr.next;
        } 

        return ansHead.next;
    }
}
