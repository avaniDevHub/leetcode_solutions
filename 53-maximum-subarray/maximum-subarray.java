class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Keep track of the overall maximum sum encountered
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}