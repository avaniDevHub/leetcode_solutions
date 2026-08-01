class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int count=0;
        StringBuilder ans= new StringBuilder();
        int n= s.length();
        for(int i = n-1; i>=0;i--)
        {
            if(s.charAt(i) != '-')
            {
                count++;
                ans.append(Character.toUpperCase(s.charAt(i)));

                if(count ==k)
                {
                    ans.append('-');
                    count=0;
                }
            }

        }
        //make sure the last character is not a dash 
        if(ans.length() >0 && ans.charAt(ans.length()-1)== '-')
        {
            ans= new StringBuilder(ans.substring(0,ans.length()-1));

        }
        //reversing the string 
        ans.reverse();
        return ans.toString();
    }
}
