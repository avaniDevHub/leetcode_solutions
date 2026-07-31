class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // Check if character is uppercase
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Convert uppercase to lowercase via ASCII shift (+32 or bitwise OR with 32)
                chars[i] = (char) (chars[i] | 32);
            }
        }

        return new String(chars);
    }
}