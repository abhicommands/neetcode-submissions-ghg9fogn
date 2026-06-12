class Solution {
    //remapping 2d->1d
    //remapping quick reminder: 
    //indexLast = rows*col -1; 
    //indexfront = 0;
    //cols = matrix[0].length;(inside length)
    // //iterating: 
    // for(int i = 0; i<indexLast; i++) {
    //     int r = i/cols; // so like if its 4x4, that means 0, 1, 2, 3()3/4 = 0, so first row. And 4 mod 4 = the length so yea it makes sense
    //     int c = i%cols;
    // }
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
