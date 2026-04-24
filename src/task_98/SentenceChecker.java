package task_98;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (24.04.2026)
 */
public class SentenceChecker {

    public static void main(String[] args) {

        String input = "Hello world. this is wrong. Valid sentence! Another One?";

        checkStream(input);
    }

    public static void checkStream(String input) {

        StringBuilder buffer = new StringBuilder();

        boolean start = true;
        boolean lastWasSpace = false;
        boolean valid = true;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            // Start of a new sentence
            if (start) {

                // Skip leading spaces before sentence
                if (c == ' ') {
                    continue;
                }

                if (!Character.isUpperCase(c)) {
                    valid = false;
                }

                buffer.append(c);
                start = false;
                lastWasSpace = false;
                continue;
            }

            // Check valid characters
            if (Character.isLowerCase(c)) {

                buffer.append(c);
                lastWasSpace = false;

            } else if (c == ' ') {

                // No double spaces
                if (lastWasSpace) {
                    valid = false;
                }

                buffer.append(c);
                lastWasSpace = true;

            } else if (c == ',' || c == ';' || c == ':') {

                // separators allowed inside sentence
                buffer.append(c);
                lastWasSpace = false;

            } else if (c == '.' || c == '?' || c == '!' || c == '‽') {

                // Terminal mark must follow a word (not space)
                if (lastWasSpace) {
                    valid = false;
                }

                buffer.append(c);

                // End of sentence → check and print
                if (valid) {
                    System.out.println("VALID: " + buffer.toString());
                } else {
                    System.out.println("INVALID: " + buffer.toString());
                }

                // Reset for next sentence
                buffer.setLength(0);
                start = true;
                lastWasSpace = false;
                valid = true;

            } else {
                // Invalid character
                valid = false;
                buffer.append(c);
            }
        }
    }

}
