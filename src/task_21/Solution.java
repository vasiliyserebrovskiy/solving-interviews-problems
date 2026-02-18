package task_21;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.02.2026)
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(makeBalanced("(()"));      // (())
        System.out.println(makeBalanced("))()("));    // ()()
    }

    public static String makeBalanced(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
                result.append(c);

            } else if (c == ')') {

                if (balance > 0) {
                    balance--;
                    result.append(c);
                }
                // otherwise, skip it - delete the extra ')'
            }
        }

        // If balance > 0 we need to add missing closing brackets
        while (balance > 0) {
            result.append(')');
            balance--;
        }

        return result.toString();
    }
}
