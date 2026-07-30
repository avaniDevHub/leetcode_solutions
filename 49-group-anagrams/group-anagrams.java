import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            
            // Create the key from sorted characters
            String key = String.valueOf(charArray);

            // Put the original string into the map bucket
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        // Return all grouped lists
        return new ArrayList<>(map.values());
    }
}