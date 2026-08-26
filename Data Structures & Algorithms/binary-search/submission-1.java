class Solution {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = start + (end - start) / 2;
        int left = search(nums, start, mid, target);
        if (left != -1) {
            return left;
        }
        return search(nums, mid + 1, end, target);
    }
}
