class Solution {
    public int maxSubArray(int[] nums) {
        int i =0, j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) 
                sum = 0;
            
        }
        return max;
    }
}

