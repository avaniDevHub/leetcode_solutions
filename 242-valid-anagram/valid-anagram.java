import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: If lengths differ, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        // Step 2: Count frequency of each character in 's'
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Step 3: Decrement frequency using characters from 't'
        for (char c : t.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            
            // If character doesn't exist or runs out, not an anagram
            if (currentCount == 0) {
                return false;
            }
            
            counts.put(c, currentCount - 1);
        }

        return true;
    }
}