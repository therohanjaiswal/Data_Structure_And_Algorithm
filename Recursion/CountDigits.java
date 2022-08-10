
public class CountDigits {
    public static void main(String[] args) {
        int n = 123;
        System.out.print(countDigits(n));
    }

    public static int countDigits(int n) {
        // single digit number
        if (n / 10 == 0)
            return 1;
        return 1 + countDigits(n / 10);
    }
}
