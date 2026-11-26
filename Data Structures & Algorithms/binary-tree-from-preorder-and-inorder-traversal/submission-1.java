class Solution {

    private final Map<Integer, Integer> indexes = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = indexes.get(root.val);

        root.left = build(preorder, l, index - 1);
        root.right = build(preorder, index + 1, r);

        return root;
    }
}
