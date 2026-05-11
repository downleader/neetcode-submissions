class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixes[i] = nums[i] * (i > 0 ? prefixes[i - 1] : 1);
        }

        int[] postfixes = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            postfixes[i] = nums[i] * (i < nums.length - 1 ? postfixes[i + 1] : 1);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prefix = i > 0 ? prefixes[i - 1] : 1;
            int postfix = i < nums.length - 1 ? postfixes[i + 1] : 1;
            result[i] = prefix * postfix;
        }

        return result;
    }
}
