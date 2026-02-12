class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node nextNode = current.next;
                Node childHead = flatten(current.child);
                
                current.next = childHead;
                childHead.prev = current;
                current.child = null;
                
                Node childTail = childHead;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                
                childTail.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = childTail;
                }
            }
            current = current.next;
        }
        
        return head;
    }
}
