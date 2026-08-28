class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        int left = 1;
        int right = maxPile + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = calcHours(piles, mid);
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left <= maxPile ? left : -1;
    }

    private long calcHours(int[] piles, int n) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (long) Math.ceil((double) piles[i] / (double) n);
        }
        return hours;
    }
}
