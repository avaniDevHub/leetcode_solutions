import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int rightVal = nums[right];
            freqMap.put(rightVal, freqMap.getOrDefault(rightVal, 0) + 1);

            // Shrink window from the left if current number's count exceeds k
            while (freqMap.get(rightVal) > k) {
                int leftVal = nums[left];
                freqMap.put(leftVal, freqMap.get(leftVal) - 1);
                left++;
            }

            // Record maximum valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}