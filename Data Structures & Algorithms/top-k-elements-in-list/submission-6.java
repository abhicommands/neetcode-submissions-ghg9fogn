class Solution {

    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    class MinHeap {
        int size;
        int capacity;
        Pair[] arr;

        public MinHeap(int cap) {
            capacity = cap;
            size = 0;
            arr = new Pair[cap];
        }

        // parent = (i - 1) / 2
        // left   = 2 * i + 1
        // right  = 2 * i + 2

        public void offer(Pair val) {

            // CASE 1: heap is not full yet
            if (size < capacity) {
                arr[size] = val;

                int i = size;
                size++;

                // SIFT UP
                while (i > 0) {
                    int parent = (i - 1) / 2;

                    // min heap is already valid
                    if (arr[parent].freq <= arr[i].freq) {
                        break;
                    }

                    swap(parent, i);
                    i = parent;
                }

                return;
            }

            // CASE 2: heap is full

            // root = smallest frequency currently in top K
            // new value isn't better, ignore it
            if (val.freq <= arr[0].freq) {
                return;
            }

            // new value IS better than our weakest top-K element
            // replace the root
            arr[0] = val;

            // restore min heap by moving new root downward
            siftDown(0);
        }

        private void siftDown(int i) {

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                int smallest = i;

                if (left < size &&
                    arr[left].freq < arr[smallest].freq) {
                    smallest = left;
                }

                if (right < size &&
                    arr[right].freq < arr[smallest].freq) {
                    smallest = right;
                }

                // heap already valid
                if (smallest == i) {
                    break;
                }

                swap(i, smallest);
                i = smallest;
            }
        }

        private void swap(int i, int j) {
            Pair temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        // STEP 1: count frequencies
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // STEP 2: custom fixed-size min heap
        MinHeap heap = new MinHeap(k);

        // STEP 3: send every unique number into heap
        for (int x : freq.keySet()) {
            heap.offer(new Pair(x, freq.get(x)));
        }

        // STEP 4: heap now contains exactly top K
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.arr[i].num;
        }

        return result;
    }
}