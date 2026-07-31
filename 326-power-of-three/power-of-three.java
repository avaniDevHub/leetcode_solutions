class Solution {
    public boolean isPowerOfThree(int n) {
        // Must be positive and divide 3^19 cleanly
        return n > 0 && 1162261467 % n == 0;
    }
}