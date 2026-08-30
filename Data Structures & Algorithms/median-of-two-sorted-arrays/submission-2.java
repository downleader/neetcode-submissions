class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        int prev1 = 0;
        int prev2 = 0;

        while (i < m || j < n) {
            prev1 = prev2;
            if (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    prev2 = nums1[i++];
                } else {
                    prev2 = nums2[j++];
                }
            } else if (i < m) {
                prev2 = nums1[i++];
            } else {
                prev2 = nums2[j++];
            }
            if (i + j == (m + n) / 2 + 1) {
                break;
            }
        }

        if ((m + n) % 2 == 1) {
            return (double) prev2;
        } else {
            return (prev1 + prev2) / 2.0;
        }
    }
}
