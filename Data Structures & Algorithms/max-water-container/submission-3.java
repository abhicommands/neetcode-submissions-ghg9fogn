class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int total = 0;
        while(left<right) {
            if(heights[left]>=heights[right]) {
                total=Math.max(total,(heights[right]*(right-left)));
                right--;
            } else {
                total=Math.max(total,(heights[left]*(right-left)));
                left++;
            }
        }
        return total;
    }
}
