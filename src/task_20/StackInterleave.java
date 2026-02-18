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
    public static void main(String[] args) {
        // Define our stack
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // temp print
        System.out.println("Initial stack: " + stack);
        interleaveStack(stack);
        System.out.println("After interleaving stack: " + stack);
    }

    public static void interleaveStack(Stack<Integer> stack) {
        // Define the queue
        Queue<Integer> queue = new LinkedList<>();

        // Check input stack
        if (stack == null || stack.isEmpty()) {
            System.out.println("Wrong input stack!");
            return;
        }

        // Stack size
        int n = stack.size();
        // Half of a stack
        int k = n / 2;

//        System.out.println("Stack size: " + n + ", Stack half: " + k );

        // Step 1: Reversing all elements in stack using queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        //System.out.println("Reversing stack: " + stack);

        // Step 2: Take k first elements from stack to the queue
        for (int i = 0; i < k; i++) {
            queue.offer(stack.pop());
        }

        // Step 3: Now we need to reverse back elements in stack
        // for this we will do
        // 1 take all elements from stack o the queue
        // 2 put first k elements from queue beginning to the queue end
        // 3 put n - k element to the stack

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < k; i++) {
            queue.offer(queue.poll());
        }
        for (int i = 0; i < n - k; i++) {
            stack.push(queue.poll());
        }
        //System.out.println("Our stack now: " + stack);
        //System.out.println("Our queue now: " + queue);

        // Step 4: Now we need to put elements in the wright order to the queue
        // we alternate elements from queue and stack for k elements in queue
        // after that we offer all elemets from stack to the queue
        // final stap we put all elements from queue to the stack as results

        for (int i = 0; i < k; i++) {
            queue.offer(queue.poll()); // take element from queue
            queue.offer(stack.pop()); // take element from stack
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

    }

}
