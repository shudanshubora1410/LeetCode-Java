class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        
        ListNode current = head;
        int carry = 0;
        ListNode prev = null;
        
        while (current != null) {
            int doubled = current.val * 2 + carry;
            current.val = doubled % 10;
            carry = doubled / 10;
            prev = current;
            current = current.next;
        }
        
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        
        return reverse(head);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
