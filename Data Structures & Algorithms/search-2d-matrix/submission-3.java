class Solution {
    //remapping 2d->1d
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows*cols -1;
        int mid;
        while(left<=right) {
            mid = left+(right-left)/2;
            int value = matrix[mid/cols][mid%cols];
            if(value == target) return true;
            else if (value > target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}
