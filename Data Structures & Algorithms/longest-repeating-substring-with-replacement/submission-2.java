public class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() ==1) return 1;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        int res = 0;
        int l = 0;
        int maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r)-'A']++;
            maxf = mostFrequentCharacter(count);
            while ((r - l + 1) - maxf > k) {
                count[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    public int mostFrequentCharacter(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count = Math.max(count, i);
        }
        return count;
    }
}