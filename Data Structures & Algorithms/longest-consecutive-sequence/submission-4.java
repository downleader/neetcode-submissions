class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i] - 1, 0);
                int right = map.getOrDefault(nums[i] + 1, 0);
                int length = left + right + 1;
                map.put(nums[i], length);
                if (map.containsKey(nums[i] - left)) {
                    map.put(nums[i] - left, length);
                }
                if (map.containsKey(nums[i] + right)) {
                    map.put(nums[i] + right, length);
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
