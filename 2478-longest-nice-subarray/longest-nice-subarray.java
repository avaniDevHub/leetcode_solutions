class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int usedBits = 0;
            for (int j = i; j < n; j++) {
                // If there is a bit collision, this subarray is invalid
                if ((usedBits & nums[j]) != 0) {
                    break;
                }
                // Add current number's bits to our mask
                usedBits |= nums[j];
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
}