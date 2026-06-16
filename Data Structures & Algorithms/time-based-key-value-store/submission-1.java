class TimeMap {
    class Value {
        String value;
        int timeStamp;
        public Value(String val, int time) {
            value = val;
            timeStamp = time;
        }
    }
    Map<String, List<Value>> map;
    public TimeMap() {
        map = new HashMap<String, List<Value>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Value>());
        }
        map.get(key).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        List<Value> arr = map.get(key);
        if (arr.get(0).timeStamp > timestamp)
            return "";
        int i = 0;
        int j = arr.size() - 1;
        int mid;
        String res = "";
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (arr.get(mid).timeStamp <= timestamp) {
                res = arr.get(mid).value;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }
}
