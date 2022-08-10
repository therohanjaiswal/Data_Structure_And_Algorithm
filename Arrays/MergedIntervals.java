// https://www.geeksforgeeks.org/merging-intervals/  
import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(1)
    public static int[][] mergeEfficient(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return null;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
    
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        for(int[] interval: merged)
            System.out.println(interval[0] + " " + interval[1]);
    }
}