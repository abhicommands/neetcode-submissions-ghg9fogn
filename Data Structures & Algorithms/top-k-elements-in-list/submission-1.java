class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i <= nums.length; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int pointer = 0;
        for (int i = nums.length; i > 0; i--) {
            for (int j = 0; j < res.get(i).size(); j++) {
                    result[pointer] = res.get(i).get(j);
                    pointer++;
                    if(pointer==k) return result;
            }
        }

        return result;
    }
}