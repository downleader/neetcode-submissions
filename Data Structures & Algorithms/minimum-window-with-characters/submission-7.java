class Solution {

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int matches = 0;
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            sCount.put(rc, sCount.getOrDefault(rc, 0) + 1);
            if (tCount.containsKey(rc)) {
                if (sCount.get(rc).equals(tCount.get(rc))) {
                    matches++;
                }
            }
            while (matches == tCount.size()) {
                if ((r - l + 1) < minLength) {
                    start = l;
                    end = r;
                    minLength = r - l + 1;
                }
                char lc = s.charAt(l);
                sCount.put(lc, sCount.get(lc) - 1);
                if (tCount.containsKey(lc) && sCount.get(lc).equals(tCount.get(lc) - 1)) {
                    matches--;
                }
                l++;
            }
        }

        return (minLength != Integer.MAX_VALUE) ? s.substring(start, end + 1) : "";
    }
}
