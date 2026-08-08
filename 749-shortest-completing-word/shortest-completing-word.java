class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                target[Character.toLowerCase(c) - 'a']++;
            }
        }

        String res = null;

        for (String x : words) {
            if (res != null && x.length() >= res.length()) continue; // Skip longer words early

            int[] count = new int[26];
            for (char c : x.toCharArray()) {
                count[c - 'a']++;
            }

            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < target[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) res = x;
        }

        return res;
    }
}