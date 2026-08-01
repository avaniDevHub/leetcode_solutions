class Solution {
    public String toHex(int num) {
        // Base case for 0
        if (num == 0) {
            return "0";
        }

        char[] hexMap = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder result = new StringBuilder();

        // Process maximum 8 nibbles (32 bits / 4 bits per hex digit)
        while (num != 0) {
            // Get last 4 bits (num & 15) and map to hex character
            result.append(hexMap[num & 15]);
            
            // Unsigned right shift by 4 bits
            num >>>= 4;
        }

        // Reverse since characters were appended from right-to-left
        return result.reverse().toString();
    }
}