package task_44;

public class Collatz {

    public static int collatzLength(long n) {
        int length = 1; // count number it self

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }

        return length;
    }

    public static void main(String[] args) {

        int maxLength = 0;
        int numberWithMax = 0;

        for (int i = 1; i <= 1_000_000; i++) {
            int length = collatzLength(i);

            if (length > maxLength) {
                maxLength = length;
                numberWithMax = i;
            }
        }

        System.out.println("Max length: " + maxLength);
        System.out.println("Number: " + numberWithMax);
    }

}
