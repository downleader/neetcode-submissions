class Solution {

    public void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode node = head;

        int count = 0;
        while (node != null && node.next != null) {
            node = node.next.next;
            mid = mid.next;
            count++;
        }

        ListNode prev = null;
        node = mid;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        node = head;
        for (int i = 0; i < count; i++) {
            ListNode nodeNext = node.next;
            ListNode prevNext = prev.next;

            node.next = prev;
            node.next.next = nodeNext;

            node = nodeNext;
            prev = prevNext;
        }

        node.next = null;
    }
}
