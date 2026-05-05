class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (counts.containsKey(delta)) {
                return new int[] { counts.get(delta), i };
            }
            counts.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
