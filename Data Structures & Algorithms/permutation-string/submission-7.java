class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] table = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a'] += 1;
        }

        int j = 0;
        int i = 0;
        int[] newTable;

        while (j < s2.length()) {
            int index = s2.charAt(j) - 'a';
            if (table[index] == 0) {
                j++;
                continue;
            }
            newTable = table.clone();
            i = j;
            while (j < s2.length() && j - i < s1.length()) {
                index = s2.charAt(j) - 'a';
                if (newTable[index] ==0 && table[index] > 0) {
                    while (i<j && s2.charAt(i) - 'a' == index) {
                        newTable[s2.charAt(i) - 'a'] += 1;
                        i++;
                    }
                }
                if (newTable[index] == 0) {
                    break;
                }
                newTable[index] -= 1;
                j++;
            }
            if (j - i == s1.length()) {
                return true;
            }
            j = i + 1;
        }

        return false;
    }
}