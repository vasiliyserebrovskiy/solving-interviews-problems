package task_06;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.02.2026)
 */
public class RectangleIntersection {
    public static int intersectionArea(Rectangle r1, Rectangle r2) {

        int intersectionWidth =
                Math.min(r1.right(), r2.right()) -
                        Math.max(r1.left(), r2.left());

        int intersectionHeight =
                Math.min(r1.top(), r2.top()) -
                        Math.max(r1.bottom(), r2.bottom());

        if (intersectionWidth <= 0 || intersectionHeight <= 0) {
            return 0;
        }

        return intersectionWidth * intersectionHeight;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 4, 3, 3);
        Rectangle r2 = new Rectangle(0, 5, 4, 3);

        System.out.println(intersectionArea(r1, r2)); // 6
    }
}
