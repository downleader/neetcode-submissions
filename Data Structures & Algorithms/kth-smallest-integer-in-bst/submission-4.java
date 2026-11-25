class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        int count = k;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            if (--count == 0) {
                return node.val;
            }

            current = node.right;
        }

        return -1;
    }
}
