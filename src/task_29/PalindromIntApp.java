package task_29;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (21.02.2026)
 */
public class PalindromIntApp {

    public static void main(String[] args) {
        int int1 = 121;
        int int2 = 888;
        int int3 = 678;

        System.out.println("int1 isPalindromeHalf = " + isPalindromeHalf(int1));
        System.out.println("int2 isPalindromeHalf = " + isPalindromeHalf(int2));
        System.out.println("int3 isPalindromeHalf = " + isPalindromeHalf(int3));
        System.out.println("=====");
        System.out.println("int1 isPalindrome = " + isPalindrome(int1));
        System.out.println("int2 isPalindrome = " + isPalindrome(int2));
        System.out.println("int3 isPalindrome = " + isPalindrome(int3));
    }

    // Solution 1: Reversing half of a number
    static boolean isPalindromeHalf(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf
                || x == reversedHalf / 10;
    }


    // Solution 2: using two pointers
    static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int div = 1;

        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {

            int left = x / div;
            int right = x % 10;

            if (left != right) return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
}
