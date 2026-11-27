class Solution {

    private int preIndex = 0;
    private int inIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int limit) {
        if (preIndex == preorder.length) {
            return null;
        }
        if (inorder[inIndex] == limit) {
            inIndex++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, limit);
        return root;
    }
}
