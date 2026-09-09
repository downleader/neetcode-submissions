class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        node.next = head;
        int count = 0;

        while (head != null) {
            count++;
            if (count == k) {
                ListNode next = head.next;
                ListNode start = node.next;
                reverse(start, head);

                node.next = head;
                start.next = next;

                node = start;
                head = start.next;

                count = 0;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        while (start != end) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        end.next = prev;
    }
}
