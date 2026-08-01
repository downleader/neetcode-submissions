class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i < s.length() && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }
            if (i >= s.length()) {
                break;
            }
            while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            if (j < 0) {
                break;
            }
            if (!matches(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private boolean matches(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
}
