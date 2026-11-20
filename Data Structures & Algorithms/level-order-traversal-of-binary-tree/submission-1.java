class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(root, 0));

        while (!queue.isEmpty()) {
            LevelNode node = queue.remove();
            if (result.size() <= node.level) {
                result.add(new ArrayList<>());
            }
            result.get(node.level).add(node.node.val);
            if (node.node.left != null) {
                queue.add(new LevelNode(node.node.left, node.level + 1));
            }
            if (node.node.right != null) {
                queue.add(new LevelNode(node.node.right, node.level + 1));
            }
        }

        return result;
    }

    private static class LevelNode {
        final TreeNode node;
        final int level;

        LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
