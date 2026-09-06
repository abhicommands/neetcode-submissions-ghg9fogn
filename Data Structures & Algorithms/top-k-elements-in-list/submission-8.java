class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Frequency map
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // 2. bucket[index] = numbers appearing "index" times
        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        // 3. Put each number into its frequency bucket
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            bucket.get(count).add(num);
        }

        // 4. Walk backwards from highest frequency
        int[] res = new int[k];
        int index = 0;

        for (int count = nums.length; count >= 1; count--) {

            for (int num : bucket.get(count)) {
                res[index++] = num;

                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}