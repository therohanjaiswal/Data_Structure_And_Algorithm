// https://www.geeksforgeeks.org/find-second-largest-element-array/
class Solution {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Second Largest Element: " + secondLargestElement(arr));
    }

    // TC: O(n), SC: O(1)
    public static int secondLargestElementEfficient(int[] arr) {
        int largest = Integer.MIN_VALUE;
        // secLargest = INT_MIN,, if second largest doesn't exists.
        // eg: [10, 10, 10, 10]
        int secLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secLargest && arr[i] != largest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}
