class Solution {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head != null ? head.next : null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode node = slow.next;
        slow.next = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        node = head;
        while (prev != null) {
            ListNode leftNext = node.next;
            ListNode rightNext = prev.next;

            node.next = prev;
            prev.next = leftNext;

            node = leftNext;
            prev = rightNext;
        }
    }
}
