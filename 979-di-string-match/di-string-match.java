class Solution {
    public int[] diStringMatch(String s) {
        int[] result= new int[s.length()+1];
        int lp=0; int rp=s.length();
        int index=0;

        //for(Character ch: s.toCharArray())
        for(int i=0;i<s.length(); i++) 
        {
            if(s.charAt(i)=='I')
            {
                result[index]= lp;
                index++;
                lp++;
            }
            else
            {
                result[index]= rp--;
                index++;
            }

        }
    if(s.charAt(s.length()-1) =='I')
    {
        result[index]= lp;

    }
    else
    {
        result[index]= rp;
    }
    return result;
}
}