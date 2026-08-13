class Solution {

    public int maxArea(int[] heights) {
        int amount = 0;

        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            amount = Math.max(amount, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return amount;
    }
}
