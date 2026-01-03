class Solution {
    public int hIndex(int[] citations) {
        int ans=0;
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--)
        {
            if(ans<citations[i])
            {
                ans++;
            }
            else
                break;
        }
        return ans;
    }
}

//max number nikalna hai where the frequency of that number is greater than number itself