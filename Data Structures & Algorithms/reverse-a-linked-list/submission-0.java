class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode root = head;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            root = head;
            head = next;
        }
        return root;
    }
}
