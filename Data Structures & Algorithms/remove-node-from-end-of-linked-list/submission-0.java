class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size++;
        }

        if (n >= size) {
            return head.next;
        }

        node = head;
        int skip = size - n - 1;
        while (skip > 0) {
            node = node.next;
            skip--;
        }

        ListNode nextNext = node.next != null ? node.next.next : null;
        node.next = nextNext;

        return head;
    }
}
