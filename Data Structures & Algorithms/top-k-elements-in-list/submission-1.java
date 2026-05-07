class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(new int[] { entry.getKey(), entry.getValue() });
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.remove()[0];
        }

        return result;
    }
}
