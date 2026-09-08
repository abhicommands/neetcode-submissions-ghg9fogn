class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int table [] = new int[26];
        for (char x : s1.toCharArray()) {
            table[x-'a']++;
        }
        int i= 0;
        int j= s1.length()-1;
        while(j<s2.length()) {
            int newTable[] = new int[26];
            int temp = i;
            while(temp<=j) {
                newTable[s2.charAt(temp)-'a']++;
                temp++;
            }
            if(compareTable(newTable, table)) return true;
            i++;
            j++;
        }
        return false;
        
    }
    public boolean compareTable(int[] arr, int[] arr2) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]!=arr2[i])
            return false;
        }
        return true;
    }
}