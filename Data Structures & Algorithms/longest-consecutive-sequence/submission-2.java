class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length ==0) return 0; if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int res = 1;
        int i =0;
        int j = 0;
        while (j < nums.length) {
            j = i+1;
            int temp = 1;
            while(i < nums.length && j< nums.length && (nums[j] == nums[i]+1 || nums[j] == nums[i])) {
                if (nums[j] == nums[i]+1 ) temp++;
                i++;
                j++;
            }
            i++;
            res = Math.max(res, temp);
        }
        return res;
    }
}
