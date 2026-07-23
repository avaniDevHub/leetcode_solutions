class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int start = 0;

        for (int i = 0; i <= n; i++) {
            // Reached the end of a word or end of the string
            if (i == n || arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1; // Move start to the first character of the next word
            }
        }

        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}