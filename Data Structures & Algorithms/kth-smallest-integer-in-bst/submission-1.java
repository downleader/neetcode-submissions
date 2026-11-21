class Solution {

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        traverse(root, k, minHeap);

        int result = 0;
        while (!minHeap.isEmpty()) {
            result = minHeap.remove();
        }
        return result;
    }

    private void traverse(TreeNode root, int k, PriorityQueue<Integer> minHeap) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            traverse(root.left, k, minHeap);
        }

        if (minHeap.size() == k) {
            return;
        }
        minHeap.add(root.val);

        if (root.right != null) {
            traverse(root.right, k, minHeap);
        }
    }
}
