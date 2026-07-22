class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0;
        int count0 = 0;
        int count1 = 0;
        int totalSubstrings = 0;

        for (int right = 0; right < s.length(); right++) {
            // Track character counts
            if (s.charAt(right) == '0') {
                count0++;
            } else {
                count1++;
            }

            // Shrink window if BOTH '0's and '1's exceed k
            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }

            // All substrings ending at 'right' starting from 'left' to 'right' are valid
            totalSubstrings += (right - left + 1);
        }

        return totalSubstrings;
    }
}