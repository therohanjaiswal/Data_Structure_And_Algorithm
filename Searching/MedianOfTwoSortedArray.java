// https://www.youtube.com/watch?v=NTop3VTjmxk 
class Solution {
    // TC: O(min(logn, logm)), SC: O(1)
    public static int findMedian(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        // arr1 should always be smaller array than arr2
        if (n > m)
            return medianOfArrays(m, n, b, a);

        int low = 0, high = n;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];

            int right1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 5, 9 };
        int[] arr2 = { 2, 3, 6, 7 };

        System.out.println("Median of combined sorted array: " + findMedian(arr1, arr2));
    }
}