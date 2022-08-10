
// https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(1)
    public static int maxActivities(int[] st, int[] ft, int n) {
        Activity[] arr = new Activity[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new Activity(st[i], ft[i]);
        }

        Arrays.sort(arr, new Comparator<Activity>() {
            public int compare(Activity s1, Activity s2) {
                return s1.finish - s2.finish;
            }
        });

        int count = 1; // first activity is always selected
        int i = 0; // pointer to track selected activites
        System.out.println("(" + arr[i].start + ", " + arr[i].finish + ")");

        for (int j = 1; j < n; ++j) {
            if (arr[j].start >= arr[i].finish) {
                System.out.println("(" + arr[j].start + ", " + arr[j].finish + ")");
                ++count;
                i = j;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };
        int n = s.length;

        System.out.println("Maximum number of activities possible: " + maxActivities(s, f, n));
    }
}

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}