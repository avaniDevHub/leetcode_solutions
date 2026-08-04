class Solution {
    public int countBinarySubstrings(String s) {
        int cur=1, prev=0, ans=0;
        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i-1)!=s.charAt(i))
            {
                ans+= Math.min(prev, cur);
                prev= cur;
                cur=1;
            }
            else
            {
                cur++;
            }
        }
        return ans+= Math.min(prev, cur);
    }
}