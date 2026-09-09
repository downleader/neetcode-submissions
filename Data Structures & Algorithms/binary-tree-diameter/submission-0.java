class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        traverse(root, result);
        return result[0];
    }

    private int[] traverse(TreeNode node, int[] result) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = traverse(node.left, result);
        int[] right = traverse(node.right, result);
        int leftMax = Math.max(left[0], left[1]);
        int rightMax = Math.max(right[0], right[1]);
        if (leftMax + rightMax > result[0]) {
            result[0] = leftMax + rightMax;
        }
        return new int[] { leftMax + 1, rightMax + 1 };
    }
}
