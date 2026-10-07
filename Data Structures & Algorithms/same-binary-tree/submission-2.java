class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode nodeP = q1.poll();
            TreeNode nodeQ = q2.poll();

            if (nodeP == null && nodeQ == null) {
                continue;
            }

            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }

            q1.add(nodeP.left);
            q1.add(nodeP.right);

            q2.add(nodeQ.left);
            q2.add(nodeQ.right);
        }

        return true;
    }
}
