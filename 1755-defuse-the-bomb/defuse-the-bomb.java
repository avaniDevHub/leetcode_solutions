class Solution {
    private int[] makePre(int[] code, int k, int n) {
        int[] pre = new int[n];
        int sum = 0;
        for (int i = 1; i <= k; i++)
            sum += code[i % n];
        pre[0] = sum;
        for (int i = 1; i < n; i++) {
            sum += code[(i + k) % n] - code[i];
            pre[i] = sum;
        }
        return pre;
    }

    private int[] makeSuf(int[] code, int k, int n) {
        int[] suf = new int[n];
        int sum = 0;
        for (int i = 1; i <= k; i++)
            sum += code[(n - i) % n];
        suf[0] = sum;
        for (int i = 0; i < n - 1; i++) {
            sum += code[i] - code[(n - k + i) % n];
            suf[i + 1] = sum;
        }
        return suf;
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0)
            return new int[n];
        if (k > 0)
            return makePre(code, k, n);
        return makeSuf(code, Math.abs(k), n);
    }
}