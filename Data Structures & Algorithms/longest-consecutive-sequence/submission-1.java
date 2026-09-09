class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0) return 0; if(nums.length ==1) return 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int x : set) {
            int tempCount=1;
            int val = x+1;
            while(set.contains(val)) {
                tempCount++;
                val++;
            }
            val = x-1;
            while(set.contains(val)){
                tempCount++;
                val--;
            }
            res = Math.max(tempCount, res);
        }
        return res;
    }
}
