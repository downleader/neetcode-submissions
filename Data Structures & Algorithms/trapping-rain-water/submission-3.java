class Solution {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if (!stack.isEmpty()) {
                    int width = i - stack.peek() - 1;
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    result += (minHeight - height[bottom]) * width;
                }
            }
            stack.push(i);
        }

        return result;
    }
}
