class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) high = Math.max(high, pile);
        if (h == piles.length) return high;
        int res = high;
        int mid, hours;
        while (low <= high) {
            mid = low + (high - low) / 2;
            hours = 0;
            for (int pile : piles) hours += (pile + mid - 1) / mid;
            if (hours<=h) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}