class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[nums.length - k + 1];

        int current = 0;
        result[current++] = map.lastEntry().getKey();

        for (int i = k; i < nums.length; i++) {
            map.put(nums[i - k], map.get(nums[i - k]) - 1);
            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            result[current++] = map.lastEntry().getKey();
        }

        return result;
    }
}
