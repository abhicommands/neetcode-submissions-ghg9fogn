class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int innerLength=matrix[0].length;
        if((target > matrix[matrix.length-1][innerLength-1]) || (target < matrix[0][0]) )
            return false;
        int left =0;
        int right =matrix.length-1;
        int mid = 0;
        while(left<=right) {
            mid = left+(right-left)/2;
            if(matrix[mid][innerLength-1]==target) return true;
            else if(matrix[mid][innerLength-1] < target) left = mid+1;
            else right = mid-1;
        }
        return searchArray(matrix[left], target);
    }
    public boolean searchArray(int[] arr, int target) {
        int left= 0 ;
        int right =arr.length-1;
        int mid;
        while(left<=right) {
            mid = left+((right-left)/2);
            if(arr[mid] == target) return true;
            else if(arr[mid] <target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
