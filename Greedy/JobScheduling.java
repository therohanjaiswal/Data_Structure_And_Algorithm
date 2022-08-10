
// https://www.geeksforgeeks.org/job-sequencing-problem/
import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(n)
    public static int[] scheduleJobs(Job[] arr, int n) {
        int[] res = { 0, 0 };
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit;
            }
        });

        int maxTime = 0;
        for (Job j : arr)
            if (j.deadline >= maxTime)
                maxTime = j.deadline;

        boolean[] isScheduled = new boolean[maxTime];
        int[] job = new int[maxTime];

        for (int i = 0; i < n; ++i) {
            for (int j = Math.min(maxTime - 1, arr[i].deadline - 1); j >= 0; --j) {
                if (isScheduled[j] == false) {
                    isScheduled[j] = true;
                    job[j] = arr[i].id;
                    ++res[0];
                    res[1] += arr[i].profit;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Job[] arr = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
        int n = arr.length;
        int[] res = scheduleJobs(arr, n);
        System.out.println("No of jobs scheduled: " + res[0] + ", Total profit: " + res[1]);
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}