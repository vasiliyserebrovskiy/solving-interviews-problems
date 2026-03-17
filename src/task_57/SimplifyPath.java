package task_57;

import java.util.Stack;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.03.2026)
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        String[] parts = path.split("/"); // break it down by "/"
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // ignore empty segments or "."
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // return to the higher level
                }
            } else {
                stack.push(part); // adding a segment to the stack
            }
        }

        // collecting the result
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // if the stack is empty, this is the root
        if (result.length() == 0) {
            return "/";
        } else {
            result.append("/"); // add "/" at the end, if necessary, as in the example
            return result.toString();
        }
    }

    public static void main(String[] args) {
        String path = "/usr/bin/../bin/./scripts/../";
        String simplified = simplifyPath(path);
        System.out.println("Original: " + path);
        System.out.println("Simplified: " + simplified); // "/usr/bin/"
    }

}
