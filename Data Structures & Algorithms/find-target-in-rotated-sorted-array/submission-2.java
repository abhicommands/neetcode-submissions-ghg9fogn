class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
// [5,1,2,3,4]
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (target > nums[mid] || target < nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
