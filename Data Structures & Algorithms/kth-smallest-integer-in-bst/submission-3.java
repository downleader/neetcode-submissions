class Solution {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;

        int count = k;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                    continue;
                } else {
                    prev.right = null;
                }
            }
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }
}
