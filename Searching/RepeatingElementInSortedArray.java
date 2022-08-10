class Solution {
    // Numbers are from 1 to n-1 in an array of n elements
    // Observation: If an element ‘X’ is repeating, then it must be at index ‘X’ in
    // the array. So the problem reduces to find any element whose value is same as
    // its index.
    // TC: O(logn), SC: O(1)
    public static int findElement(int[] arr, int low, int high) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] != mid + 1) {
            if (mid > 0 && arr[mid] == arr[mid - 1])
                return mid;
            return findElement(arr, low, mid - 1);
        }

        return findElement(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 5 };
        System.out.println("Repeating element: " + findElement(arr, 0, arr.length - 1));
    }
}