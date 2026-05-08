class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder
                .append(s.length())
                .append("|")
                .append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if ("".equals(str)) {
            return result;
        }

        Stack<Character> lenStack = new Stack<>();
        StringBuilder current = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            while (i < str.length() && str.charAt(i) != '|') {
                lenStack.push(str.charAt(i++));
            }
            int length = 0;
            int power = 0;
            while (!lenStack.isEmpty()) {
                length += (lenStack.pop() - '0') * (int) Math.pow(10f, power++);
            }
            current.setLength(0);
            for (int j = 0; j < length; j++) {
                current.append(str.charAt(++i));
            }
            result.add(current.toString());
            i++;
        }

        return result;
    }
}
