class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;

        // Construct prefixGcd array: prefixGcd[i] = gcd(nums[i], max(nums[0...i]))
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        // Sort to pair smallest and largest
        Arrays.sort(prefixGcd);

        long ans = 0;
        // Sum GCDs of pairs: (smallest, largest), (2nd smallest, 2nd largest), etc.
        for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }

        return ans;
    }

    // Euclidean algorithm to compute GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}