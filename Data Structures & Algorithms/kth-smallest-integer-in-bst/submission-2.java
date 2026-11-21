class Solution {

    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        traverse(root, k, result);
        return result[1];
    }

    private void traverse(TreeNode node, int k, int[] result) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            traverse(node.left, k, result);
        }

        if (result[0] == k) {
            return;
        }

        result[0]++;
        result[1] = node.val;

        if (node.right != null) {
            traverse(node.right, k, result);
        }
    }
}
