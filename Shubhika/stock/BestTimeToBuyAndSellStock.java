package arrays;

/**
 * LeetCode 121 - Best Time to Buy and Sell Stock (Easy)
 *
 * Problem: Given an array prices[] where prices[i] is the price of a stock on day i,
 * return the maximum profit you can achieve by buying on one day and selling on a later day.
 * If no profit is possible, return 0.
 *
 * Approach: Single pass — track the minimum price seen so far, and at each step
 * compute the profit if we sold today. Update max profit accordingly.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;           // found a cheaper buy day
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // found a better profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2)); // Output: 0 (no profit possible)
    }
}
