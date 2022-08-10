import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = { 800, 700, 600, 500 };
        int[] dep = { 840, 820, 830, 530 };
        System.out.println("No of Guest I can meet: " + meetingTime(arr, dep));
    }

    // public static int meetingTime(int[] arr, int[] dep) {
    // Arrays.sort(arr);
    // Arrays.sort(dep);
    // int noOfGuestsToMeet = 0;
    // int start = arr[0];
    // int end = dep[0];
    // for (int i = 1; i < arr.length; ++i) {
    // if (start <= arr[i] && arr[i] <= end) {
    // start = arr[i];
    // end = Math.min(end, dep[i]);
    // ++noOfGuestsToMeet;
    // } else {
    // start = arr[i];
    // end = dep[i];
    // }
    // }
    // System.out.println("Start: " + start + " End: " + end);
    // return noOfGuestsToMeet;
    // }

    public static int meetingTime(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int currGuestsToMeet = 1, totalGuestToMeet = 1;
        int i = 1, j = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                ++currGuestsToMeet;
                ++i;
            } else {
                --currGuestsToMeet;
                ++j;
            }
            totalGuestToMeet = Math.max(totalGuestToMeet, currGuestsToMeet);
        }
        return totalGuestToMeet;
    }
}
