class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0; int j=0, sum=0, len=Integer.MAX_VALUE;
        while(j<nums.length)
        {
            sum+=nums[j];

            while(sum>=target)
            {
                len=Math.min(len,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE?0:len;
    }
}