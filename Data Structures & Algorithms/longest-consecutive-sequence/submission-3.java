class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet();
        for(int x : nums) set.add(x);
        int count = 1;
        int tempCount=1;
        while(!set.isEmpty()) {
            int x = set.iterator().next();
            set.remove(x);
            tempCount = 1;
            int next = x + 1;
            while(set.contains(next)) {
                set.remove(next);
                tempCount++;
                next++;
            }
            int prev = x - 1;
            while(set.contains(prev)) {
                set.remove(prev);
                tempCount++;
                prev--;
            }
            count = Math.max(tempCount, count);
        }
        return count;
    }
}
