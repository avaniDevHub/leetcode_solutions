class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        int n= strs.length;
        int k= strs[0].length();

        for(int i=0;i<k; i++)
        {
            for(int j=1;j<n; j++)
            {
                // Corrected: use charAt(i) to fetch character at index i
                if (strs[j].charAt(i) < strs[j - 1].charAt(i))
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}