class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];

        int current = 0;
        result[current++] = heap.peek();

        for (int i = k; i < nums.length; i++) {
            heap.remove(nums[i - k]);
            heap.add(nums[i]);
            result[current++] = heap.peek();
        }

        return result;
    }
}
