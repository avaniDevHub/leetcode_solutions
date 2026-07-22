import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is already in our sliding window, we found a match within distance k
            if (window.contains(nums[i])) {
                return true;
            }
            
            // Add the current element to the window
            window.add(nums[i]);
            
            // Maintain the sliding window size of at most k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}