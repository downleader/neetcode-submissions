class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();

        int index = 0;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            if (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            deque.addLast(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.getFirst()];
            }
        }

        return result;
    }
}
