class Solution {
    // Binary Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0; // Tracks how many active numbers pass through this node
    }

    private void insert(TrieNode root, int val) {
        TrieNode curr = root;
        for (int i = 20; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
            curr.count++;
        }
    }

    private void remove(TrieNode root, int val) {
        TrieNode curr = root;
        for (int i = 20; i >= 0; i--) {
            int bit = (val >> i) & 1;
            curr = curr.children[bit];
            curr.count--;
        }
    }

    private int getMaxXor(TrieNode root, int val) {
        TrieNode curr = root;
        int maxXor = 0;
        
        for (int i = 20; i >= 0; i--) {
            int bit = (val >> i) & 1;
            int oppositeBit = 1 - bit;

            // We prefer taking the opposite bit to maximize XOR (1 ^ 0 = 1)
            if (curr.children[oppositeBit] != null && curr.children[oppositeBit].count > 0) {
                maxXor |= (1 << i);
                curr = curr.children[oppositeBit];
            } else {
                curr = curr.children[bit];
            }
        }
        
        return maxXor;
    }

    public int maximumStrongPairXor(int[] nums) {
        // Step 1: Sort the array to easily maintain y <= 2 * x
        java.util.Arrays.sort(nums);

        TrieNode root = new TrieNode();
        int left = 0;
        int maxXor = 0;

        // Step 2: Sliding window with right pointer
        for (int right = 0; right < nums.length; right++) {
            // Add current element into the Trie
            insert(root, nums[right]);

            // Maintain condition: nums[right] <= 2 * nums[left]
            // If violated, remove nums[left] from Trie and advance left pointer
            while (nums[right] > 2 * nums[left]) {
                remove(root, nums[left]);
                left++;
            }

            // Find the maximum XOR for nums[right] with all valid nums[x] in Trie
            maxXor = Math.max(maxXor, getMaxXor(root, nums[right]));
        }

        return maxXor;
    }
}