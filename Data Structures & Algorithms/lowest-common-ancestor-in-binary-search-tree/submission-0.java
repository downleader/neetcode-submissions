class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[1];
        traverse(root, p, q, result);
        return result[0];
    }

    private void traverse(TreeNode root, TreeNode p, TreeNode q, TreeNode[] result) {
        if (root.left != null) {
            traverse(root.left, p, q, result);
        }
        if (root.right != null) {
           traverse(root.right, p, q, result); 
        }
        if (hasChild(root, p) && hasChild(root, q)) {
            if (result[0] == null) {
                result[0] = root;
            }
        }
    }

    private boolean hasChild(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return hasChild(root.left, node) || hasChild(root.right, node);
    }
}
