package task_01.subtype;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (29.01.2026)
 */
public class SubTypeApp {
    public static void main(String[] args) {

        Shape s1 = new Circle();
        Shape s2 = new Square();

        s1.draw();  // Drawing a Circle
        s2.draw();  // Drawing a Square
    }
}
