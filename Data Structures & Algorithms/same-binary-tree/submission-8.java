class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { p, q });

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode pNode = nodes[0];
            TreeNode qNode = nodes[1];

            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }

            stack.push(new TreeNode[] { pNode.right, qNode.right });
            stack.push(new TreeNode[] { pNode.left, qNode.left });
        }

        return true;
    }
}
