class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] count = new int[26];

            // count letters
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            // build key
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append('#').append(c);
            }

            String key = sb.toString();

            // add word to correct group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}