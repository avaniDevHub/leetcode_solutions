class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isjewel= new boolean[128];
        for(char j: jewels.toCharArray())
        {
            isjewel[j]= true;
        }

        int count=0;
        for(char s: stones.toCharArray())
        {
            if(isjewel[s])
            {
                count++;
            }
        }
        return count;
    }
}