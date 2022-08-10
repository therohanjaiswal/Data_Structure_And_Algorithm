// https://www.geeksforgeeks.org/stock-buy-sell/

class Solution {
    // In this problem, we can buy and sell stocks multiple times.
    // In the naive approach we are taking every pair between start and end.
    // TC: O(n^2), SC: O(1)
    public static int findMaxProfitNaive(int[] arr, int start, int end) {
        if (end <= start)
            return 0;
        int profit = 0;
        for (int i = start; i < end; i++) {
            // j acts as a separator between start and end
            // we compute profit between [start, i-1] + [i, j] + [j+1, end]
            for (int j = i + 1; j <= end; j++) {
                if (arr[j] > arr[i]) {
                    int curr_profit = arr[j] - arr[i] + findMaxProfit(arr, start, i - 1)
                            + findMaxProfit(arr, j + 1, end);
                    profit = Math.max(curr_profit, profit);
                }
            }
        }

        return profit;
    }

    // TC: O(n), SC: O(1)
    public static int findMaxProfitEfficient(int[] arr) {
        int buy = -1, sell = -1;
        int profit = 0, i;

        for (i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                if (buy == -1)
                    buy = i - 1;
                profit += arr[i] - arr[i - 1];
            } else if (arr[i - 1] > arr[i]) {
                if (buy != -1) {
                    sell = i - 1;
                    System.out.println(buy + " - " + sell);
                    buy = sell = -1;
                }
            }
        }

        if (buy != -1) {
            sell = i - 1;
            System.out.println(buy + " - " + sell);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 1, 2, 8 };
        // int maxProfit = findMaxProfit(arr, 0, arr.length - 1);
        int maxProfit = findMaxProfit2(arr);
        System.out.println("Max profit - " + maxProfit);
    }
}
