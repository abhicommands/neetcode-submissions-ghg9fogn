class Solution {
    public boolean isAnagram(String s, String t) {
        //string1: 
        //string2: 
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                int a = map.get(c)-1;
                map.put(c, a);
                if (a == 0) map.remove(c);
            } else {
                return false;
            }
        }
        if(map.isEmpty()) return true;
        else return false;


    }
}
