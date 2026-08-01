class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;
        int n = word.length();

        // Count the number of uppercase characters
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                uppercaseCount++;
            }
        }

        // Case 1: All capitals (e.g., "USA")
        if (uppercaseCount == n) {
            return true;
        }

        // Case 2: All lowercase (e.g., "leetcode")
        if (uppercaseCount == 0) {
            return true;
        }

        // Case 3: Only the first letter is capital (e.g., "Google")
        if (uppercaseCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}