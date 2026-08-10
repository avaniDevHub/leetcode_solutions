class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
         return false;

        String doubled= s+s;
        int n= s.length();

        //check every possible starting position in doubled
        for(int i=0;i<n; i++)
        {
            boolean match= true;
            for(int j=0;j<n;j++)
            {
                if(doubled.charAt(i+j) != goal.charAt(j))
                {
                    match= false;
                    break;
                }
            }
            if(match){
                return true;
            }
        }
        return false;
    }
}