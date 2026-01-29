package task_01.parametric;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (29.01.2026)
 */
public class ParametricApp {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(123);
        Box<String> strBox = new Box<>("Hello");

        System.out.println(intBox.getValue());  // 123
        System.out.println(strBox.getValue());  // Hello
    }
}
