class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            // Find a valid starting element: must be even AND <= threshold
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int start = i;
                
                // Keep extending as long as alternating parity and threshold are satisfied
                while (i + 1 < n && nums[i + 1] <= threshold && (nums[i] % 2 != nums[i + 1] % 2)) {
                    i++;
                }
                
                // Update max length
                maxLength = Math.max(maxLength, i - start + 1);
            }
            
            i++;
        }

        return maxLength;
    }
}