package task_47;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (03.03.2026)
 */
public class ExcelColumn {

    // A method for converting a number to a column letter
    public static String convertToColumn(int number) {
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            number--;  // the key point for proper operation
            int remainder = number % 26;
            char letter = (char) ('A' + remainder);
            result.append(letter);
            number /= 26;
        }

        return result.reverse().toString();
    }

    // Test
    public static void main(String[] args) {
        int[] testNumbers = {1, 26, 27, 52, 703}; // test examples

        for (int num : testNumbers) {
            System.out.println(num + " -> " + convertToColumn(num));
        }
    }
}


