class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = remove(head, n);
        if (size == n) {
            return head.next;
        } else {
            return head;
        }
    }

    private int remove(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int count = remove(head.next, n);
        if (count == n) {
            head.next = head.next.next;
        }
        return count + 1;
    }
}
