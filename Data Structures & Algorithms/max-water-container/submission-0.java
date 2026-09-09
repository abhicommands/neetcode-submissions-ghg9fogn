class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int i = 0;
        int j = heights.length-1; 
        while (i < j) {
            int width = j-i; 
            int length = Math.min(heights[j], heights[i]);
            int tempArea = length*width;
            area = Math.max(tempArea, area);
            if (heights[i] <= heights[j])
                i++;
            else
                j--;
        }
        return area;
    }
}
