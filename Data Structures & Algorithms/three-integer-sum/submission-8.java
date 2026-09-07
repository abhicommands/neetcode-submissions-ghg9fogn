class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        int left;
        int right;
        int target;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            target = 0 - nums[i];
            // two sum 2
            if(i>0 && nums[i] == nums[i-1]) continue;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    while((left<right) && (nums[left+1]==nums[left]))
                    left++;
                    while((left<right) && (nums[right-1]==nums[right]))
                    right--;
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] > target)
                    right--;
                else
                    left++;
            }
        }
        return res;
    }
}
