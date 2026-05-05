class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (counts.containsKey(delta) && counts.get(delta) != i) {
                return new int[] { i, counts.get(delta) };
            }
        }
        return new int[0];
    }
}
