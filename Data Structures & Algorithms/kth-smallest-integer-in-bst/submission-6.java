class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            current = node.right;
        }

        return -1;
    }
}
