class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        traverse(root, result);
        return result[0];
    }

    private int traverse(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }

        int left = traverse(node.left, result);
        int right = traverse(node.right, result);
        
        if (left + right > result[0]) {
            result[0] = left + right;
        }

        return Math.max(left, right) + 1;
    }
}
