package task_01.parametric;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (29.01.2026)
 */

/**
 * Parametric polymorphism
 * This is when a function or class works with any data type, but the type is determined when it is used.
 * In Java, this is done through generics.
 * It is often called “generic polymorphism.”
 */
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
