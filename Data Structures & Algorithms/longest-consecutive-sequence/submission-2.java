class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexes.put(nums[i], i);
        }
        UnionFind uf = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (indexes.get(nums[i]) != i) {
                continue;
            }
            if (indexes.containsKey(nums[i] - 1)) {
                uf.union(i, indexes.get(nums[i] - 1));
            }
            if (indexes.containsKey(nums[i] + 1)) {
                uf.union(i, indexes.get(nums[i] + 1));
            }
        }
        return uf.longestSequence();
    }

    private static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        void union(int i, int j) {
            int iParent = find(i);
            int jParent = find(j);

            if (iParent == jParent) {
                return;
            }

            if (rank[iParent] > rank[jParent]) {
                parent[jParent] = iParent;
            } else if (rank[iParent] < rank[jParent]) {
                parent[iParent] = jParent;
            } else {
                parent[jParent] = iParent;
                rank[jParent] = rank[jParent] + 1;
            }
        }

        int longestSequence() {
            int[] counts = new int[parent.length];
            for (int i = 0; i < parent.length; i++) {
                int p = find(parent[i]);
                counts[p]++;
            }
            int max = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > max) {
                    max = counts[i];
                }
            }
            return max;
        }
    }
}
