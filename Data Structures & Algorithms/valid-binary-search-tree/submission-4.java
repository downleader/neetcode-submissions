class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] range = new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
        return isValid(root, range);
    }

    private boolean isValid(TreeNode node, int[] range) {
        if (node == null) {
            return true;
        }
        if (node.val <= range[0] || node.val >= range[1]) {
            return false;
        }
        return isValid(node.left, new int[] { range[0], node.val })
            && isValid(node.right, new int[] { node.val, range[1] });
    }
}
