class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        //[2,-3,4,-2,2,1,-1,4]
        int i =0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (j < nums.length) {
            sum +=nums[j];
            max = Math.max(sum, max);
            if (sum < 0) {
                i = j;
                sum = 0;
            }
            j++;
        }
        return max;

    }
}
