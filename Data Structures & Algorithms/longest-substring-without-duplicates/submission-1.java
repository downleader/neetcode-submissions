class Solution {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int start = 0;
        int end = 0;

        Set<Character> window = new HashSet<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (window.contains(c)) {
                while (start < end && s.charAt(start) != c) {
                    window.remove(s.charAt(start));
                    start++;
                }
                window.remove(s.charAt(start++));
            }
            window.add(c);
            end++;
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }
}
