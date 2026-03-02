class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        int groupNum = 2;
        
        while (prev.next != null) {
            ListNode groupStart = prev.next;
            ListNode curr = groupStart;
            int count = 0;
            
            while (curr != null && count < groupNum) {
                curr = curr.next;
                count++;
            }
            
            if (count % 2 == 0) {
                ListNode nextGroupStart = curr;
                ListNode[] reversed = reverse(groupStart, count);
                prev.next = reversed[0];
                reversed[1].next = nextGroupStart;
                prev = reversed[1];
            } else {
                for (int i = 0; i < count; i++) {
                    prev = prev.next;
                }
            }
            
            groupNum++;
        }
        
        return head;
    }
    
    private ListNode[] reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode curr = head;
        
        for (int i = 0; i < count; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return new ListNode[]{prev, head};
    }
}
