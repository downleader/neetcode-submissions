class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode[] result = new ListNode[1];
        reverse(head, result);
        return result[0];
    }

    private ListNode reverse(ListNode node, ListNode[] result) {
        if (node == null) {
            return node;
        }
        ListNode next = reverse(node.next, result);
        if (next != null) {
            next.next = node;
        } else {
            if (result[0] == null) {
                result[0] = node;
            }
        }
        node.next = null;
        return node;
    }
}
