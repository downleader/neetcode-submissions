class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isSameTree(node, subRoot)) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();

            if (pNode.val != qNode.val) {
                return false;
            }

            if (pNode.right != null) {
                pStack.push(pNode.right);
            }
            if (pNode.left != null) {
                pStack.push(pNode.left);
            }

            if (qNode.right != null) {
                qStack.push(qNode.right);
            }
            if (qNode.left != null) {
                qStack.push(qNode.left);
            }
        }

        return pStack.isEmpty() && qStack.isEmpty();
    }
}
