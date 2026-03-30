package task_71;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (30.03.2026)
 */
public class PointInPolygon {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point[] polygon = {
                new Point(0, 0),
                new Point(5, 0),
                new Point(5, 5),
                new Point(0, 5)
        };

        Point inside = new Point(3, 3);
        Point outside = new Point(6, 3);
        Point boundary = new Point(5, 3);

        System.out.println("Inside: " + isInside(polygon, inside));   // true
        System.out.println("Outside: " + isInside(polygon, outside)); // false
        System.out.println("Boundary: " + isInside(polygon, boundary)); // false
    }

    public static boolean isInside(Point[] polygon, Point p) {
        int intersections = 0;
        int n = polygon.length;

        for (int i = 0; i < n; i++) {
            Point a = polygon[i];
            Point b = polygon[(i + 1) % n];

            // 1. Verification: a point on the border
            if (onSegment(a, b, p)) {
                return false;
            }

            // 2. Checking the intersection of the ray to the right
            if ((a.y > p.y) != (b.y > p.y)) {
                double xIntersection =
                        (b.x - a.x) * (p.y - a.y) / (b.y - a.y) + a.x;

                if (xIntersection > p.x) {
                    intersections++;
                }
            }
        }

        return intersections % 2 == 1;
    }

    // Check whether the point p lies on the segment ab
    public static boolean onSegment(Point a, Point b, Point p) {
        return cross(a, b, p) == 0 &&
                p.x >= Math.min(a.x, b.x) &&
                p.x <= Math.max(a.x, b.x) &&
                p.y >= Math.min(a.y, b.y) &&
                p.y <= Math.max(a.y, b.y);
    }

    // Vector product (orientation)
    public static double cross(Point a, Point b, Point p) {
        return (b.x - a.x) * (p.y - a.y) -
                (b.y - a.y) * (p.x - a.x);
    }

}
