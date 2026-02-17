package task_20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.02.2026)
 */
public class StackInterleave {
    public static void interleaveStack(Stack<Integer> stack) {
        if (stack == null || stack.size() <= 1) return;

        int n = stack.size();
        Queue<Integer> queue = new LinkedList<>();

        // Moving all the items from the stack to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // We move the elements back to the stack.
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        int halfSize = n / 2;

        // Moving the first half to the queue
        for (int i = 0; i < halfSize; i++) {
            queue.offer(stack.pop());
        }

        // TODO: need to write this part! Noe it is did not work!!!
        // Interleave the items from the queue and the remaining stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll()); // we take an element from the first half
            if (!stack.isEmpty()) {
                stack.push(stack.pop()); // we take an element from the second half (reverse order)
            }
        }
    }

    // Test
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.addAll(Arrays.asList(1, 2, 3, 4, 5)); // top = 5
        System.out.println("Start stack: " + stack1);
        interleaveStack(stack1);
        System.out.println("After the interleaving: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.addAll(Arrays.asList(1, 2, 3, 4)); // top = 4
        System.out.println("\nStart stack: " + stack2);
        interleaveStack(stack2);
        System.out.println("After the interleaving: " + stack2);
    }
}
