class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //fastest bucket sort implementation
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        for (int x : nums) {
            int count = freq.getOrDefault(x, 0) + 1;
            freq.put(x, count);

            maxFreq = Math.max(maxFreq, count);
        }

        List<Integer>[] buckets = new List[maxFreq + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        int[] res = new int[k];
        int index = 0;

        for (int count = maxFreq; count >= 1; count--) {
            if (buckets[count] == null) continue;

            for (int num : buckets[count]) {
                res[index++] = num;

                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}