class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode prev = null;
        while (list1 != null || list2 != null) {
            ListNode next = null;
            if (list2 == null || (list1 != null && list1.val <= list2.val)) {
                next = list1;
                list1 = list1.next;
            } else {
                next = list2;
                list2 = list2.next;
            }
            if (head == null) {
                head = next;
            }
            if (prev != null) {
                prev.next = next;
            }
            prev = next;
        }
        return head;
    }
}
