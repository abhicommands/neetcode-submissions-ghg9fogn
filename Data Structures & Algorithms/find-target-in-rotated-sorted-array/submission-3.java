class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target) return i;
            i++;
        }
        return -1;
    }
}
