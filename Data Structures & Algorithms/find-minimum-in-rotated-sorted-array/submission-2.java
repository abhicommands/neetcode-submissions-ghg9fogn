class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int i = 0;
        int j = nums.length/2 ;
        int k = nums.length-1;
        int min = min3(nums[i], nums[j], nums[k]);
        while (j!= k) {
            if(nums[i] >=  nums[k] && nums[j] > nums[i] ) {
                min = Math.min(min, min3(nums[j], nums[k], nums[i]));
                i = j;
                j = i + (k - i) / 2;
            } else if(nums[i] >=  nums[k]){
                min = Math.min(min, min3(nums[j], nums[k], nums[i]));
                k = j;
                j = i + (k - i) / 2;
            } else {
                return nums[i];
            }
        }
        return min;
    }
    public int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
