class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }
}
