class Solution {

    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int lastColumn = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] column = stack.pop();
                lastColumn = column[0];

                maxArea = Math.max(maxArea, column[1] * (i - column[0]));
            }
            stack.push(new int[] { lastColumn, heights[i] });
        }

        while (!stack.isEmpty()) {
            int[] column = stack.pop();
            maxArea = Math.max(maxArea, column[1] * (heights.length - column[0]));
        }

        return maxArea;
    }
}
