class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.get(nums[i]) - 1);
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                counts.put(nums[j], counts.get(nums[j]) - 1);
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                } 

                int target = -(nums[i] + nums[j]);
                if (counts.getOrDefault(target, 0) > 0) {
                    result.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                counts.put(nums[j], counts.get(nums[j]) + 1);
            }
        }

        return result;
    }
}
