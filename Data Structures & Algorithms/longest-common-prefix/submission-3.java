class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].length() == 0) return "";
        String res = "";
        int index =0;
        int shortSize = strs[0].length();
        while(index<shortSize) {
            char compare = strs[0].charAt(index);
            for(String x : strs) {
                if(x.length()==0 || x.length()<=index || x.charAt(index)!=compare)
                    return res;
            }
            res +=compare;
            index++;
        }
        return res;
        
    }
}