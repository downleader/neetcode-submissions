class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            }

            int right = n - 1 - i;
            if ((right + 1) % k == 0) {
                rightMax[right] = nums[right];
            } else {
                rightMax[right] = Math.max(rightMax[right + 1], nums[right]);
            }
        }

        int[] result = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }
        return result;
    }
}
