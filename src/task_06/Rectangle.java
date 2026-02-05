package task_06;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.02.2026)
 */
public class Rectangle {
    int x;      // top-left x
    int y;      // top-left y
    int width;
    int height;

    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    int left() {
        return x;
    }

    int right() {
        return x + width;
    }

    int top() {
        return y;
    }

    int bottom() {
        return y - height;
    }
}
