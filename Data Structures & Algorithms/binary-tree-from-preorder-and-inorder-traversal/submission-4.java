class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.MAX_VALUE);
        TreeNode curr = head;

        int i = 0;
        int j = 0;

        while (j < inorder.length) {
            if (curr.val == inorder[j]) {
                TreeNode next = curr.right;
                curr.right = null;
                curr = next;
                j++;
            } else if (i < preorder.length) {
                TreeNode node = new TreeNode(preorder[i]);
                node.right = curr;
                if (curr.left == null) {
                    curr.left = node;
                } else {
                    TreeNode prev = curr.left;
                    while (prev.right != null) {
                        prev = prev.right;
                    }
                    prev.right = node;
                }
                curr = node;
                i++;
            } else {
                TreeNode next = curr.right;
                curr.right = null;
                curr = next;
            }
        }

        return head.left;
    }
}