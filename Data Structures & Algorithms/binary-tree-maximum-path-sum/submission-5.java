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
        result[0] = Math.max(result[0], node.val);

        int leftMax = findMaxPath(node.left, result);
        int rightMax = findMaxPath(node.right, result);

        result[0] = Math.max(result[0], leftMax + node.val);
        result[0] = Math.max(result[0], rightMax + node.val);
        result[0] = Math.max(result[0], leftMax + node.val + rightMax);

        return Math.max(node.val, Math.max(node.val + leftMax, node.val + rightMax));
    }
}
