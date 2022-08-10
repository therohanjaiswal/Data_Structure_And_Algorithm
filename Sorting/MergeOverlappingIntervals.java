import java.util.*;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 1; i < intervals.length; ++i) {
            if (start <= intervals[i][0] && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] { start, end });
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println("Before: ");
        for (int i = 0; i < intervals.length; ++i) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }
        int[][] result = merge(intervals);
        System.out.println("After Merging overlapping intervals: ");
        for (int i = 0; i < result.length; ++i) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
