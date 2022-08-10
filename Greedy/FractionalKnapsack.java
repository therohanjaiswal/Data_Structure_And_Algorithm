
// https://www.geeksforgeeks.org/fractional-knapsack-problem/
import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(1)
    public static double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                return i2.value * i1.weight - i1.value * i2.weight;
            }
        });

        int i = 0;
        double profit = 0.0;
        while (W > 0 && i < n) {
            int currItemVal = arr[i].value;
            int currItemWgt = arr[i].weight;

            if (currItemWgt <= W) {
                profit += currItemVal;
                W -= currItemWgt;
            } else {
                // Do not use,
                // double fraction = W/currItemWgt, as this will return integer
                double fraction = (double) W / (double) currItemWgt;
                profit += currItemVal * fraction;
                W -= fraction * currItemWgt;
            }
            ++i;
        }

        return profit;
    }

    public static void main(String[] args) {
        Item[] arr = { new Item(60, 10), new Item(100, 20) };
        int n = arr.length;
        int W = 50;
        System.out.println("Maximum profit: " + fractionalKnapsack(W, arr, n));
    }
}

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}