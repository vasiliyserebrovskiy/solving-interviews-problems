package task_01.ad_hoc;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (29.01.2026)
 */

/**
 * Ad-hoc polymorphism:
 * This is when the same operator or function behaves differently for different types.
 * It is usually implemented through overloading or operator overloading.
 * It is often called “overload polymorphism.”
 */
public class MathUtils {
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }
}
