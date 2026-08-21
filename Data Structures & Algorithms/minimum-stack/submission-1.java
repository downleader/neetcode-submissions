class MinStack {

    private final Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];
        stack.push(new int[] { val, Math.min(val, min) });
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
