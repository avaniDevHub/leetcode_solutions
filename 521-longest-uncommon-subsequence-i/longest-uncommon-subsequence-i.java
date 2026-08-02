class Solution {
    public int findLUSlength(String a, String b) {
        // If the strings are identical, every subsequence of 'a' 
        // is also in 'b', so no uncommon subsequence exists.
        if (a.equals(b)) {
            return -1;
        }
        
        // Otherwise, the longer string itself can never be a 
        // subsequence of the shorter string.
        return Math.max(a.length(), b.length());
    }
}