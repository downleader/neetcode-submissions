class Solution {

    public int evalRPN(String[] tokens) {
        long[] result = eval(tokens, tokens.length - 1);
        return (int) result[0];
    }

    private long[] eval(String[] tokens, int index) {
        String token = tokens[index];
        if (isOperator(token)) {
            long[] right = eval(tokens, index - 1);
            long[] left = eval(tokens, (int) right[1] - 1);
            long[] result = new long[2];
            switch (token) {
                case "+":
                    result[0] = left[0] + right[0];
                    break;
                case "-":
                    result[0] = left[0] - right[0];
                    break;
                case "*":
                    result[0] = left[0] * right[0];
                    break;
                case "/":
                    result[0] = left[0] / right[0];
                    break;
                default:
                    break;
            }
            result[1] = (int) left[1];
            return result;
        } else {
            return new long[] { Long.valueOf(token), index };
        }
    }

    private boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}
