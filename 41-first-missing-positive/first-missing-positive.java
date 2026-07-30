class Solution {
    public int firstMissingPositive(int[] nums) {
        //loop1: replace numbers which are negative, zero or greater than araay size to another nuumber
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]<=0 || nums[i] > nums.length)
            {
                nums[i]= nums.length+1;
            }
        }

        //loop 2: mark the presence
        for(int i=0;i<nums.length;i++)
        {
            int num= Math.abs(nums[i]);
            if(num>nums.length) continue;

            if(nums[num-1] >0)
            {
                nums[num-1] = - nums[num-1];
            }
        }

        //find the frst missing posiiitive
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] >0)
            {
                return i+1;
            }
        }
        return nums.length+1;//very important cse

    }
}