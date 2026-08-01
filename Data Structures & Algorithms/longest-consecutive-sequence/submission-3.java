class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int longest = 1;
                int next = nums[i] + 1;
                while (set.contains(next)) {
                    next++;
                    longest++;
                }
                result = Math.max(result, longest);
            }
        }
        return result;
    }
}
