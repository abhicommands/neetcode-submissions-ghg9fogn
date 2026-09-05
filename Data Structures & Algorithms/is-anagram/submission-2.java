class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] list = new int[26];
        for (int i =0; i < s.length(); i++) {
            list[s.charAt(i)-'a']++;
            list[t.charAt(i)-'a']--;
        }
        for(int x : list) {
            if( x != 0)
            return false;
        }
        return true;
    }
}