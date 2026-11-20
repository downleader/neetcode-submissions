class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (hasLarger(root.left, root.val) || hasSmaller(root.right, root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean hasLarger(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val >= val) {
            return true;
        }
        return hasLarger(node.left, val) || hasLarger(node.right, val);
    }

    private boolean hasSmaller(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val <= val) {
            return true;
        }
        return hasSmaller(node.left, val) || hasSmaller(node.right, val);
    }
}
