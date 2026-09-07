class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        PriorityQueue<HeapNode> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.node.val, b.node.val)
        );
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                heap.add(new HeapNode(lists[i], i));
            }
        }

        while (!heap.isEmpty()) {
            HeapNode min = heap.remove();
            node.next = min.node;
            node = node.next;

            lists[min.index] = lists[min.index].next;
            if (lists[min.index] != null) {
                heap.add(new HeapNode(lists[min.index], min.index));
            }
        }

        return dummy.next;
    }

    private static class HeapNode {
        final ListNode node;
        final int index;

        HeapNode(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
