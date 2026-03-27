package task_70;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (27.03.2026)
 */
public class MinMaxOptimized {

    static class Result {
        int min;
        int max;

        Result(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static Result findMinMax(int[] arr) {
        int n = arr.length;

        int min, max;
        int i;

        // if there are an odd number of elements
        if (n % 2 == 1) {
            min = max = arr[0];
            i = 1;
        } else {
            // если имеется нечетное количество элементов
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        }

        // go by pairs
        while (i < n - 1) {
            int a = arr[i];
            int b = arr[i + 1];

            if (a < b) {
                if (a < min) min = a;
                if (b > max) max = b;
            } else {
                if (b < min) min = b;
                if (a > max) max = a;
            }

            i += 2;
        }

        return new Result(min, max);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4, 8};

        Result res = findMinMax(arr);

        System.out.println("Min = " + res.min);
        System.out.println("Max = " + res.max);
    }

}
