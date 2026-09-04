class Solution {

    public void reorderList(ListNode head) {
        reorder(head, head != null ? head.next : null);
    }

    private ListNode reorder(ListNode root, ListNode node) {
        if (node == null) {
            return root;
        }

        ListNode newRoot = reorder(root, node.next);
        if (newRoot == null) {
            return null;
        }

        ListNode next = null;
        if (newRoot == node || newRoot.next == node) {
            node.next = null;
        } else {
            ListNode temp = newRoot.next;
            newRoot.next = node;
            node.next = temp;
            next = temp;
        }

        return next;
    }
}
