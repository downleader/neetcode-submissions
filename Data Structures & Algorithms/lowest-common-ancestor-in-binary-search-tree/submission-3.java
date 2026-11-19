class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[1];
        traverse(root, p, q, result);
        return result[0];
    }

    private int traverse(TreeNode node, TreeNode p, TreeNode q, TreeNode[] result) {
        if (node == null) {
            return 0;
        }
        int current = (node == p || node == q) ? 1 : 0;
        int left = traverse(node.left, p, q, result);
        int right = traverse(node.right, p, q, result);
        if (current + left + right >= 2) {
            if (result[0] == null) {
                result[0] = node;
            }
        }
        return current + left + right;
    }
}
