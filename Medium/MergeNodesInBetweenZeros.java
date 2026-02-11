class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode currentNew = dummy;
        ListNode temp = head.next;
        int sum = 0;

        while (temp != null) {
            if (temp.val != 0) {
                sum += temp.val;
            } else {
                currentNew.next = new ListNode(sum);
                currentNew = currentNew.next;
                sum = 0;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}
