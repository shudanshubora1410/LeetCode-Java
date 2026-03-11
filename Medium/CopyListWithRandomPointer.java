class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        java.util.Map<Node, Node> map = new java.util.HashMap<>();
        
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}
