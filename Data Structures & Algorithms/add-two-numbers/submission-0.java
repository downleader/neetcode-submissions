class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode node = null;

        int carryOver = 0;
        while (l1 != null || l2 != null) {
            int current = carryOver;
            current += l1 != null ? l1.val : 0;
            current += l2 != null ? l2.val : 0;

            ListNode digit = new ListNode(current % 10);
            carryOver = current / 10;

            if (result == null) {
                result = digit;
                node = digit;
            } else {
                node.next = digit;
                node = node.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carryOver != 0) {
            node.next = new ListNode(carryOver);
        }

        return result;
    }
}
