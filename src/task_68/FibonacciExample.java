package task_68;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (25.03.2026)
 */
public class FibonacciExample {

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0; // F(0)
        int curr = 1; // F(1)

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public static void main(String[] args) {
        // тесты
        System.out.println("fib(0) = " + fib(0)); // 0
        System.out.println("fib(1) = " + fib(1)); // 1
        System.out.println("fib(2) = " + fib(2)); // 1
        System.out.println("fib(3) = " + fib(3)); // 2
        System.out.println("fib(5) = " + fib(5)); // 5
        System.out.println("fib(10) = " + fib(10)); // 55
    }

}
