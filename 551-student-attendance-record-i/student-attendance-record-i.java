class Solution {
    public boolean checkRecord(String s) {
        int latecount=0;
        int absentcount=0;
        for(int i=0;i<s.length(); i++)
        {
            char c= s.charAt(i);
            if(c=='A')
            {
                absentcount++;
                if(absentcount >= 2) return false;
            }
            if(c== 'L') 
            {
                latecount++;
                if(latecount == 3) return false;
            }
            else
            //When we encounter a 'P' (present), the late count resets to 0 because the streak of consecutive 'L's is broken.
            latecount=0;
        }
        return (absentcount<2 && latecount<3);

    }
}