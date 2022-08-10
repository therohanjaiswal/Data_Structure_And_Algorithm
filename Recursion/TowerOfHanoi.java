// https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
class Solution {
    public static void main(String[] args) {
        int noOfDisks = 3;
        char[] towers = { 'A', 'B', 'C' };
        getMoves(noOfDisks, towers[0], towers[1], towers[2]);
    }

    // TC: O(2^n), SC: O(1)
    public static void getMoves(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + A + " to " + C);
            return;
        }
        getMoves(n - 1, A, C, B);
        System.out.println("Move disc " + n + " from " + A + " to " + C);
        getMoves(n - 1, B, A, C);
    }
}
