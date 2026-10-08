class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] { p, q });

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.remove();
            TreeNode pNode = nodes[0];
            TreeNode qNode = nodes[1];

            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }

            queue.add(new TreeNode[] { pNode.left, qNode.left });
            queue.add(new TreeNode[] { pNode.right, qNode.right });
        }

        return true;
    }
}
