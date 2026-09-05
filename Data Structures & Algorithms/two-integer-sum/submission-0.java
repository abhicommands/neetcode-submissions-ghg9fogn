class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr= nums[i];
            if (sum.containsKey(curr)) {
                result[1] = i ;
                result[0] = sum.get(curr);
                return result;
            } else {
                sum.put(target - curr, i);
            }
        }
        return result;
    }
}
