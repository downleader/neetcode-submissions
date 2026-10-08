class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { p, q });

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode pNode = nodes[0];
            TreeNode qNode = nodes[1];
            if (pNode.val != qNode.val) {
                return false;
            }
            if (pNode.right == null && qNode.right != null ||
                pNode.right != null && qNode.right == null) {
                return false;
            }
            if (pNode.right != null && qNode.right != null) {   
                stack.push(new TreeNode[] { pNode.right, qNode.right });
            }
            if (pNode.left == null && qNode.left != null ||
                pNode.left != null && qNode.left == null) {
                return false;
            }
            if (pNode.left != null && qNode.left != null) {   
                stack.push(new TreeNode[] { pNode.left, qNode.left });
            }
        }

        return true;
    }
}
