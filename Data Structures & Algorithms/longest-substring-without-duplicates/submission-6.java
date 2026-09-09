class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int res = 1;
        int[] table = new int[128];
        Arrays.fill(table, -1);
        int i = 0;
        table[s.charAt(i)] =0;
        for (int j=1; j<s.length(); j++) {
            char x = s.charAt(j);
            if(table[x] == -1) {
                table[x] = j;
            } else {
                i = Math.max(table[x] +1, i);
                table[x] =j;
            }
            res = Math.max(j-i+1, res);
        }
        return res;
    }
}
