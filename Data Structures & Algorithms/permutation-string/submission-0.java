class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            firstMap.put(c, firstMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        if (firstMap.equals(window)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char current = s2.charAt(i);
            window.put(current, window.getOrDefault(current, 0) + 1);

            char old = s2.charAt(i - s1.length());
            window.put(old, window.get(old) - 1);
            if (window.get(old) == 0) {
                window.remove(old);
            }

            if (firstMap.equals(window)) {
                return true;
            }
        }

        return false;
    }
}
