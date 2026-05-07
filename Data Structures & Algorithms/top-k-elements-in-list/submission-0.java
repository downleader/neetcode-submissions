class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> keys = new ArrayList<>(freq.entrySet());
        Collections.sort(keys, (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i).getKey();
        }

        return result;
    }
}
