class Solution {
    public static int countAndMerge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] aux = new int[high - low + 1];
        int res = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                aux[k++] = arr[i++];
            else if (arr[i] > arr[j]) {
                aux[k++] = arr[j++];
                res += (mid - low + 1 - i);
            }

        }

        while (i <= mid)
            aux[k++] = arr[i++];

        while (j <= high)
            aux[k++] = arr[j++];

        k = 0;
        for (int l = low; l <= high; l++)
            arr[l] = aux[k++];

        return res;
    }

    public static int countInversion(int[] arr, int low, int high) {
        int res = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            res += countInversion(arr, low, mid);
            res += countInversion(arr, mid + 1, high);
            res += countAndMerge(arr, low, mid, high);
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 46, 34, 12 };
        int[] arr = { 1, 20, 6, 4, 5 };
        int n = arr.length;

        int res = countInversion(arr, 0, n - 1);
        System.out.println(res);
    }
}
