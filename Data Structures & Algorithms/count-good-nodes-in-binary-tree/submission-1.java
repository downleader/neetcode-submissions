class Solution {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root, root.val);
    }

    private int countNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int total = node.val >= max ? 1 : 0;
        total += countNodes(node.left, Math.max(node.val, max));
        total += countNodes(node.right, Math.max(node.val, max));
        return total;
    }
}
