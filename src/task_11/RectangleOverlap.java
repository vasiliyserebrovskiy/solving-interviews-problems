package task_11;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.02.2026)
 */
public class RectangleOverlap {
    static class Rectangle {
        int left, top, width, height;
        int right, bottom;

        Rectangle(int topLeftX, int topLeftY, int width, int height) {
            this.left = topLeftX;
            this.top = topLeftY;
            this.width = width;
            this.height = height;
            this.right = left + width;
            this.bottom = top - height; // y уменьшается вниз
        }
    }

    // Checking the intersection of two rectangles
    public static boolean isOverlap(Rectangle a, Rectangle b) {
        // If one is to the left of the other
        if (a.right <= b.left || b.right <= a.left)
            return false;

        // If one is higher than the other
        if (a.bottom >= b.top || b.bottom >= a.top)
            return false;

        // Otherwise they overlap
        return true;
    }

    // Checking all pairs of rectangles
    public static boolean anyOverlap(Rectangle[] rects) {
        int n = rects.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isOverlap(rects[i], rects[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Rectangle[] rects = new Rectangle[] {
                new Rectangle(1, 4, 3, 3),
                new Rectangle(-1, 3, 2, 1),
                new Rectangle(0, 5, 4, 3)
        };

        System.out.println(anyOverlap(rects)); // true
    }
}
