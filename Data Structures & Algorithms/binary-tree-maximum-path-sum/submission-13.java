class Solution {

    public int maxPathSum(TreeNode root) {
        int[] result = new int[] { Integer.MIN_VALUE };
        findMaxPath(root, result);
        return result[0];
    }

    private int findMaxPath(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(findMaxPath(node.left, result), 0);
        int rightMax = Math.max(findMaxPath(node.right, result), 0);

        result[0] = Math.max(result[0], leftMax + node.val + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
