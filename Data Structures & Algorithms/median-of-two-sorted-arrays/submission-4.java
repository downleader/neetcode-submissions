class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return getKthSmallest(nums1, 0, nums2, 0, total / 2);
        } else {
            double left = getKthSmallest(nums1, 0, nums2, 0, total / 2 - 1);
            double right = getKthSmallest(nums1, 0, nums2, 0, total / 2);
            return (left + right) / 2.0;
        }
    }

    private double getKthSmallest(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int m = nums1.length - start1;
        int n = nums2.length - start2;
        if (m > n) {
            return getKthSmallest(nums2, start2, nums1, start1, k);
        }
        if (m == 0) {
            return nums2[start2 + k];
        }
        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = Math.min(m - 1, k / 2);
        int j = Math.min(n - 1, k - i - 1);
        if (nums1[start1 + i] <= nums2[start2 + j]) {
            return getKthSmallest(nums1, start1 + i + 1, nums2, start2, k - i - 1);
        } else {
            return getKthSmallest(nums1, start1, nums2, start2 + j + 1, k - j - 1);
        }
    }
}
