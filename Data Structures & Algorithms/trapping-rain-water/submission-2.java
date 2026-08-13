class Solution {

    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            if (height[maxLeft[i - 1]] > height[i]) {
                maxLeft[i] = maxLeft[i - 1];
            } else {
                maxLeft[i] = i;
            }
        }

        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[maxRight[i + 1]] > height[i]) {
                maxRight[i] = maxRight[i + 1];
            } else {
                maxRight[i] = i;
            }
        }

        int area = 0;
        for (int i = 0; i < height.length; i++) {
            area += Math.min(height[maxLeft[i]], height[maxRight[i]]) - height[i];
        }

        return area;
    }
}
