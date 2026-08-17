class Solution {

    public int characterReplacement(String s, int k) {
        int maxLength = 0;

        int l = 0;
        while (l < s.length()) {
            int r = l + 1;
            int replacements = k;
            int firstNonRepeating = -1;
            while (r < s.length() && (replacements > 0 || s.charAt(r) == s.charAt(l))) {
                int current = s.charAt(r);
                if (current != s.charAt(l)) {
                    if (firstNonRepeating == -1) {
                        firstNonRepeating = r;
                    }
                    replacements--;
                }
                r++;
            }
            maxLength = Math.max(maxLength, Math.min(r - l + replacements, s.length()));
            l = (firstNonRepeating != -1) ? firstNonRepeating : r; 
        }

        return maxLength;
    }
}
