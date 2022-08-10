// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
// TC : O(n)
public class Solution {
    public static void seggregate(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                ++low;
                ++mid;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                --high;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 0, 1 };
        System.out.println("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");
        seggregate(arr);
        System.out.println();
        for (int a : arr)
            System.out.print(a + " ");
    }
}
