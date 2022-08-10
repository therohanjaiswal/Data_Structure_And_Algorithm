
// https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(1)
    public static int findCircuitNaive(int[] petrol, int[] dist) {
        int effPetrol = 0;
        int n = petrol.length;
        int start, end;
        for (start = 0; start < n; ++start) {
            end = start;
            effPetrol = 0;
            while (true) {
                effPetrol += petrol[end];
                if (effPetrol < dist[end])
                    break;
                else
                    effPetrol -= dist[end];
                end = ++end % n;
                if (start == end)
                    return start;
            }
        }
        return -1;
    }

    // TC: O(n), SC: O(1)
    public static int findCircuitBetter(int[] petrol, int[] dist) {
        int n = petrol.length;
        int start = 0, end = 1;
        int currPetrol = petrol[start] - dist[start];
        while (start != end || currPetrol < 0) {

            while (currPetrol < 0 && start != end) {
                currPetrol -= (petrol[start] - dist[start]);
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }

            currPetrol += (petrol[end] - dist[end]);
            end = (end + 1) % n;
        }
        return start;
    }

    // TC: O(n), SC: O(1)
    public static int findCircuitEfficient(int[] petrol, int[] dist) {
        int n = petrol.length, start = 0;
        int deficit = 0, currPetrol = 0;

        for (int i = 0; i < n; ++i) {
            currPetrol += petrol[i] - dist[i];
            if (currPetrol < 0) {
                start = i + 1;
                deficit += currPetrol;
                currPetrol = 0;
            }
        }
        return (currPetrol + deficit) >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = { 1, 2, 3, 4, 5 };
        int[] dist = { 3, 4, 5, 1, 2 };
        System.out.println(findCircuitNaive(petrol, dist));
        System.out.println(findCircuitBetter(petrol, dist));
        System.out.println(findCircuitEfficient(petrol, dist));
    }
}
