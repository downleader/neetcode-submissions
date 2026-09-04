class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = remove(head, n);
        if (size == n) {
            return head.next;
        } else {
            return head;
        }
    }

    private int remove(ListNode node, int n) {
        if (node == null) {
            return 0;
        }
        int count = remove(node.next, n);
        if (count == n) {
            node.next = node.next.next;
        }
        return count + 1;
    }
}
