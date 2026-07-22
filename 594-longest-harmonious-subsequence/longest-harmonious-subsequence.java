class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        int result = 0; // to store maximum subsequence length
        
        // Count frequencies of each number
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        
        // Find the maximum length of a harmonious subsequence
        for (int num : nums) {
            int minNum = num;
            int maxNum = num + 1;
            
            if (mp.containsKey(maxNum)) {
                result = Math.max(result, mp.get(minNum) + mp.get(maxNum));
            }
        }
        
        return result;
    }
}