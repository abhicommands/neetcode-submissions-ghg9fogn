class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);

        // bucket: index = frequency, value = list of numbers
        List<List<Integer>> bucket = new ArrayList<>();

        // initialize buckets
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        // count frequencies
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int count = 0;

            // count duplicates
            int j = i;
            while (j < nums.length && nums[j] == curr) {
                count++;
                j++;
            }

            // put number in bucket
            bucket.get(count).add(curr);

            // move i forward
            i = j - 1;
        }

        // collect top k
        int[] res = new int[k];
        int index = 0;

        for (int i = bucket.size() - 1; i >= 0 && index < k; i--) {
            for (int num : bucket.get(i)) {
                res[index++] = num;
                if (index == k) break;
            }
        }

        return res;
    }
}