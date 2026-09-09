class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] prefix= new int[length];
        int[] suffix = new int[length];
        //prefix
        //suffix
        int pref = 1;
        int suff = 1;
        int j = length-1;
        for (int i = 0; i< length; i++) {
            prefix[i] = pref; 
            // [1, 2, 3, 4] = pref = [curr = pref]
            pref*=nums[i];
            suffix[j] = suff;
            suff *=nums[j];
            j--;
        }
        //solution
        for (int i = 0; i < length; i++) {
            res[i] = suffix[i]*prefix[i];
        }
        return res;
    }
}  
