class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }

        int maxsum=sum;
        int startidx=0;
        int endidx=k;
        while(endidx<nums.length)
        {
            sum-=nums[startidx];
            startidx++;

            sum+=nums[endidx];
            endidx++;

            maxsum=Math.max(maxsum,sum);
        }
        return (double) maxsum/k;
    }
}