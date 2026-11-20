class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        traverse(node.left, level + 1, result);
        traverse(node.right, level + 1, result);
    }
}
