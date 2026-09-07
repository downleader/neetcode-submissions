class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        while (!heap.isEmpty()) {
            ListNode min = heap.remove();
            node.next = min;
            node = node.next;

            ListNode next = min.next;
            if (next != null) {
                heap.add(next);
            }
        }

        return dummy.next;
    }
}
