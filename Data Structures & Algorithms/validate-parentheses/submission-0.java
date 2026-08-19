class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') {
                    return false;
                }
                stack.push(c);
            } else {
                char p = stack.peek();
                if (p == '(' && c == ')' || p == '{' && c == '}' || p == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
