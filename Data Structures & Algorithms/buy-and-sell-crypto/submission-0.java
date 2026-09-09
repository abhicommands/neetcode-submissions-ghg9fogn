class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int result = 0;
        int i =0;
        int j = 1;
        // [10,1,5,6,7,1]
        while (j < prices.length) {
            int profit = prices[j] - prices[i];
            result = Math.max(result, profit);
            if (prices[j] < prices[i]) {
                i= j;
                j = i+1;
            } else j++;
        }
        return result;

    }
}
