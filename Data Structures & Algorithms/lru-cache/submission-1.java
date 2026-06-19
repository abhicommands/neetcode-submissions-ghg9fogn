class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode() {}
        public ListNode(int key, int value) {
            this.val = value;
            this.key = key;
        }
    }
    int totalSize;
    int currSize;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        totalSize = capacity;
        currSize = 0;
    }
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else {
            ListNode res = map.get(key);
            if (tail != res) {
                if (res != head) {
                    res.prev.next = res.next;
                    res.next.prev = res.prev;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                tail.next = res;
                res.prev = tail;
                res.next = null;
                tail = res;
            }
            return map.get(key).val;
        }
    }
    public void put(int key, int value) {
        if (currSize == 0) {
            ListNode node = new ListNode(key, value);
            node.next = null;
            node.prev = null;
            head = node;
            tail = node;
            map.put(key, tail);
            currSize++;
            return;
        }
        if (map.containsKey(key)) {
            ListNode res = map.get(key);
            if (tail != res) {
                if (res != head) {
                    res.prev.next = res.next;
                    res.next.prev = res.prev;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                tail.next = res;
                res.prev = tail;
                tail = res;
            }
            tail.val = value;
        } else {
            currSize++;
            if (currSize > totalSize) {
                int headKey = head.key;
                head = head.next;
                if (head != null)
                    head.prev = null;
                map.remove(headKey);
                currSize--;
            }
            ListNode node = new ListNode(key, value);
            node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = node;
            map.put(key, tail);
        }
    }
}
