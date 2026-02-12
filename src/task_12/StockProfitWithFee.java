package task_12;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.02.2026)
 */
public class StockProfitWithFee {
    public static int maxProfit(int[] prices, int fee) {
        // If the array is empty or less than 2 days old, there is no profit.
        if (prices == null || prices.length < 2) return 0;

        // cash — profit when shares are not in hand
        int cash = 0;
        // hold — profit when a stock is bought and in hand
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // If we sell the stock today: cash = maximum between the old cash and the hold sale
            cash = Math.max(cash, hold + prices[i] - fee);
            // If we buy the stock today: hold = maximum between the old hold and the purchase with cash
            hold = Math.max(hold, cash - prices[i]);
        }

        // In the end, the maximum profit will be in the cash state (because the hold is a stock in hand, the profit is not fixed)
        return cash;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 10};
        int fee = 2;

        int profit = maxProfit(prices, fee);
        System.out.println("Maximum profit: " + profit); // Выведет 9
    }
}
