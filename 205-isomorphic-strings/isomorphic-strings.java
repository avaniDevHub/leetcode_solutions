import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If lengths are different, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Map to store character mappings
        Map<Character, Character> charMappingMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!charMappingMap.containsKey(original)) {
                // If original character is not mapped, check if replacement is already taken
                if (!charMappingMap.containsValue(replacement)) {
                    charMappingMap.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                // If original is already mapped, check if the mapping matches
                char mappedCharacter = charMappingMap.get(original);
                if (mappedCharacter != replacement) {
                    return false;
                }
            }
        }
        return true;
    }
}