class Solution {
    public int maxSubArray(int[] nums) {
        int i =0, j = 0;
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
