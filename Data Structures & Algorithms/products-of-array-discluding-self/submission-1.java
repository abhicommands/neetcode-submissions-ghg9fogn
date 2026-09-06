class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length; 
        int res[] = new int[size];
        //prefix
        //[1, 1, 2, 8]
        //suffix
        //[48, 24, 6, 1]
        //[]
        //prefix : 
        int prefix[] = new int[size];
        prefix[0] =1;
        prefix[1] = nums[0];
        for(int i =1; i<size; i++) {
            prefix[i] = nums[i-1]*prefix[i-1];
        }
        //suffix
        int suffix[] = new int[size];
        suffix[size-1] = 1;
        suffix[size-2]=nums[size-1];
        for(int i = size-2; i>=0; i--) {
            suffix[i]=nums[i+1]*suffix[i+1];
        }
        //result; 
        for(int i=0; i<size;i++) {
            res[i] = prefix[i]*suffix[i];
        }
        return res;
        
    }
}  
