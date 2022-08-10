// Similar to Hoare Partition
// TC: O(n)
public class Solution {
    public static void segregate(int[] arr) {
        int low = -1, high = arr.length;
        while (true) {
            do {
                ++low;
            } while (arr[low] < 0);

            do {
                --high;
            } while (arr[high] >= 0);

            if (high <= low)
                return;

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 13, -12, 10, -8 };
        System.out.println("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");
        segregate(arr);
        System.out.println();
        for (int a : arr)
            System.out.print(a + " ");
    }
}
