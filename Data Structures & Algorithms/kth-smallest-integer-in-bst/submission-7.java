class Solution {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                    continue;
                } else {
                    prev.right = null;
                }
            }
            if (--k == 0) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }
}
