class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for(int x : nums) 
            freq.put(x, freq.getOrDefault(x, 0)+1);
        
        List<int[]> list = new ArrayList();

        for(int val : freq.keySet()) {
            list.add(new int[]{val, freq.get(val)});
        }
        list.sort((a, b) -> Integer.compare(b[1], a[1]));
        int res[] = new int[k];
        for (int i = 0; i <k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }
}
