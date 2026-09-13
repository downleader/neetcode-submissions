class Solution {

    public boolean isBalanced(TreeNode root) {
        boolean[] result = new boolean[] { true };
        traverse(root, result);
        return result[0];
    }

    private int traverse(TreeNode node, boolean[] result) {
        if (!result[0] || node == null) {
            return 0;
        }
        int left = traverse(node.left, result);
        int right = traverse(node.right, result);
        if (Math.abs(left - right) > 1) {
            result[0] = false;
        }
        return Math.max(left, right) + 1;
    }
}
