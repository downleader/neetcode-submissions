class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> deque = new LinkedList<>();

        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.getLast()[1] < nums[i]) {
                deque.removeLast();
            }

            if (!deque.isEmpty() && deque.getFirst()[0] <= i - k) {
                deque.removeFirst();
            }

            deque.addLast(new int[] { i, nums[i] });
            if (i >= k - 1) {
                result[index++] = deque.getFirst()[1];
            }
        }
        return result;
    }
}
