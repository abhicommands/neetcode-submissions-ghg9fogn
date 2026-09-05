class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<int[]> pairs = new ArrayList<>();

        for (int num : freq.keySet()) {
            pairs.add(new int[]{num, freq.get(num)});
        }

        pairs.sort((a, b) -> Integer.compare(b[1], a[1]));

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pairs.get(i)[0];
        }

        return res;
    }
}