class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int x : piles) max = Math.max(max, x);
        int hoursFromVal = piles.length;
        if (hoursFromVal == h) return max; 
        int res = max;
        int low = 1;
        while (low <= max) {
            int mid = (low + max) / 2;
            hoursFromVal = 0;
            for (int pile : piles) {
                hoursFromVal+= Math.ceil(pile/(double) mid);
            }
            if (hoursFromVal <= h) {
                res = mid;
                max = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
