class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int usedBits = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the incoming number shares any bit with the current window,
            // shrink the window from the left until the conflict is cleared.
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left]; // Unset bits of nums[left]
                left++;
            }

            // Include current number's bits in the active window
            usedBits |= nums[right];

            // Record the window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}