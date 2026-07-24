import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        // Process each contiguous subarray of size k
        for (int i = 0; i <= n - k; i++) {
            answer[i] = calculateXSum(nums, i, i + k - 1, x);
        }

        return answer;
    }

    private int calculateXSum(int[] nums, int start, int end, int x) {
        // Step 1: Count frequencies of elements in the current window
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = start; i <= end; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Put map entries into a list for sorting
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort by frequency descending, then by value descending
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // Higher frequency first
            }
            return b.getKey() - a.getKey(); // Larger value first if frequencies tie
        });

        // Step 4: Sum up the top x elements
        int xSum = 0;
        int count = Math.min(x, list.size()); // Keep at most x distinct numbers
        
        for (int i = 0; i < count; i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            xSum += entry.getKey() * entry.getValue();
        }

        return xSum;
    }
}