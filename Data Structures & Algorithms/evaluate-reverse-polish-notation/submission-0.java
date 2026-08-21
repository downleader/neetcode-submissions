class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                Long second = stack.pop();
                if (stack.isEmpty() && ("+".equals(token) || "-".equals(token))) {
                    if ("+".equals(token)) {
                        stack.push(second);
                    } else {
                        stack.push(-second);
                    }
                } else if (!stack.isEmpty()) {
                    Long folded = 0L;
                    switch (token) {
                        case "+":
                            folded = stack.peek() + second;
                            break;
                        case "-":
                            folded = stack.peek() - second;
                            break;
                        case "*":
                            folded = stack.peek() * second;
                            break;
                        case "/":
                            folded = stack.peek() / second;
                            break;
                        default:
                            break;
                    }
                    stack.pop();
                    stack.push(folded);
                }
            } else {
                stack.push(Long.valueOf(token));
            }
        }
        return stack.peek().intValue();
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}
