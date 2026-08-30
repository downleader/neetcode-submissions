class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;

        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int other = (total + 1) / 2 - mid;

            int aLeft = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int aRight = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;

            int bLeft = other > 0 ? nums2[other - 1] : Integer.MIN_VALUE;
            int bRight = other < nums2.length ? nums2[other] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 1) {
                    return Math.max(aLeft, bLeft);
                } else {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            } else if (aLeft > bRight) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }
}
